# encoding: utf-8
require 'rubygems/package'
require 'zlib'
require 'zip'

module Inspec
  class FileProvider
    def self.for_path(path)
      if path.is_a?(Hash)
        MockProvider.new(path)
      elsif File.directory?(path)
        DirProvider.new(path)
      elsif File.exist?(path) && path.end_with?('.tar.gz', 'tgz')
        TarProvider.new(path)
      elsif File.exist?(path) && path.end_with?('.zip')
        ZipProvider.new(path)
      elsif File.exist?(path)
        DirProvider.new(path)
      else
        raise "No file provider for the provided path: #{path}"
      end
    end

    def initialize(_path)
    end

    def read(_file)
      raise "#{self} does not implement `read(...)`. This is required."
    end

    def files
      raise "Fetcher #{self} does not implement `files()`. This is required."
    end

    def relative_provider
      RelativeFileProvider.new(self)
    end
  end

  class MockProvider < FileProvider
    attr_reader :files
    def initialize(path)
      @data = path[:mock]
      @files = @data.keys
    end

    def read(file)
      @data[file]
    end
  end

  class DirProvider < FileProvider
    attr_reader :files
    def initialize(path)
      @files = if File.file?(path)
                 [path]
               else
                 Dir[File.join(path, '**', '*')]
               end
      @path = path
    end

    def read(file)
      return nil unless files.include?(file)
      return nil unless File.file?(file)
      File.read(file)
    end
  end

  class ZipProvider < FileProvider
    attr_reader :files

    def initialize(path)
      @path = path
      @contents = {}
      @files = []
      ::Zip::InputStream.open(@path) do |io|
        while (entry = io.get_next_entry)
          @files.push(entry.name.sub(%r{/+$}, ''))
        end
      end
    end

    def read(file)
      @contents[file] ||= read_from_zip(file)
    end

    private

    def read_from_zip(file)
      return nil unless @files.include?(file)
      res = nil
      ::Zip::InputStream.open(@path) do |io|
        while (entry = io.get_next_entry)
          next unless file == entry.name
          res = io.read
          break
        end
      end
      res
    end
  end

  class TarProvider < FileProvider
    attr_reader :files

    def initialize(path)
      @path = path
      @contents = {}
      @files = []
      Gem::Package::TarReader.new(Zlib::GzipReader.open(@path)) do |tar|
        @files = tar.map(&:full_name)
      end
    end

    def read(file)
      @contents[file] ||= read_from_tar(file)
    end

    private

    def read_from_tar(file)
      return nil unless @files.include?(file)
      res = nil
      # NB `TarReader` includes `Enumerable` beginning with Ruby 2.x
      Gem::Package::TarReader.new(Zlib::GzipReader.open(@path)) do |tar|
        tar.each do |entry|
          next unless entry.file? && file == entry.full_name
          res = entry.read
          break
        end
      end
      res
    end
  end

  class RelativeFileProvider
    BLACKLIST_FILES = [
      '/pax_global_header',
      'pax_global_header',
    ].freeze

    attr_reader :files
    attr_reader :prefix
    attr_reader :parent

    def initialize(parent_provider)
      @parent = parent_provider
      @prefix = get_prefix(parent.files)
      if @prefix.nil?
        raise "Could not determine path prefix for #{parent}"
      end
      @files = parent.files.find_all { |x| x.start_with?(prefix) && x != prefix }
                     .map { |x| x[prefix.length..-1] }
    end

    def abs_path(file)
      return nil if file.nil?
      prefix + file
    end

    def read(file)
      parent.read(abs_path(file))
    end

    private

    def get_prefix(fs)
      return '' if fs.empty?

      # filter backlisted files
      fs -= BLACKLIST_FILES

      sorted = fs.sort_by(&:length)
      get_folder_prefix(sorted)
    end

    def prefix_candidate_for(file)
      if file.end_with?(File::SEPARATOR)
        file
      else
        file + File::SEPARATOR
      end
    end

    def get_folder_prefix(fs)
      return get_files_prefix(fs) if fs.length == 1
      first, *rest = fs
      pre = prefix_candidate_for(first)

      if rest.all? { |i| i.start_with? pre }
        return get_folder_prefix(rest)
      end
      get_files_prefix(fs)
    end

    def get_files_prefix(fs)
      return '' if fs.empty?

      file = fs[0]
      bn = File.basename(file)
      # no more prefixes
      return '' if bn == file

      i = file.rindex(bn)
      pre = file[0..i-1]

      rest = fs.find_all { |f| !f.start_with?(pre) }
      return pre if rest.empty?

      new_pre = get_prefix(rest)
      return new_pre if pre.start_with? new_pre
      # edge case: completely different prefixes; retry prefix detection
      a = File.dirname(pre + 'a')
      b = File.dirname(new_pre + 'b')
      get_prefix([a, b])
    end
  end
end
