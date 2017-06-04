# encoding: utf-8
#
# author: Dominik Richter
# author: Christoph Hartmann

require 'train/extras'

class Train::Transports::Local::Connection
  class File < LinuxFile
    def content
      @content ||= ::File.read(@path, encoding: 'UTF-8')
    rescue StandardError => _
      nil
    end

    %w{
      exist? file? socket? directory? symlink? pipe?
    }.each do |m|
      define_method m.to_sym do
        ::File.method(m.to_sym).call(@path)
      end
    end

    def link_path
      return nil unless symlink?
      begin
        @link_path ||= ::File.realpath(@path)
      rescue Errno::ELOOP => _
        # Leave it blank on symbolic loop, same as readlink
        @link_path = ''
      end
    end

    def block_device?
      ::File.blockdev?(@path)
    end

    def character_device?
      ::File.chardev?(@path)
    end

    private

    def pw_username(uid)
      Etc.getpwuid(uid).name
    rescue ArgumentError => _
      nil
    end

    def pw_groupname(gid)
      Etc.getgrgid(gid).name
    rescue ArgumentError => _
      nil
    end

    def stat
      return @stat if defined? @stat

      begin
        file_stat =
          if @follow_symlink
            ::File.stat(@path)
          else
            ::File.lstat(@path)
          end
      rescue StandardError => _err
        return @stat = {}
      end

      @stat = {
        type: Train::Extras::Stat.find_type(file_stat.mode),
        mode: file_stat.mode & 07777,
        mtime: file_stat.mtime.to_i,
        size: file_stat.size,
        owner: pw_username(file_stat.uid),
        uid: file_stat.uid,
        group: pw_groupname(file_stat.gid),
        gid: file_stat.gid,
      }

      lstat = @follow_symlink ? ' -L' : ''
      res = @backend.run_command("stat#{lstat} #{@spath} 2>/dev/null --printf '%C'")
      if res.exit_status == 0 && !res.stdout.empty? && res.stdout != '?'
        @stat[:selinux_label] = res.stdout.strip
      end

      @stat
    end
  end
end
