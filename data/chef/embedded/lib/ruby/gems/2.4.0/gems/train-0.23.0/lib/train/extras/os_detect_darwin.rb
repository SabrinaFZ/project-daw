# encoding: utf-8
# author: Dominik Richter
# author: Christoph Hartmann
#
# This is heavily based on:
#
#   OHAI https://github.com/chef/ohai
#   by Adam Jacob, Chef Software Inc
#
require 'train/extras/uname'

module Train::Extras
  module DetectDarwin
    include Train::Extras::Uname

    def detect_darwin
      cmd = @backend.run_command('/usr/bin/sw_vers')
      # TODO: print an error in this step of the detection,
      # as it shouldnt happen
      return false if cmd.exit_status != 0
      # TODO: ditto on error
      return false if cmd.stdout.empty?

      name = cmd.stdout[/^ProductName:\s+(.+)$/, 1]
      # TODO: ditto on error
      return false if name.nil?
      @platform[:name] = name.downcase.chomp.tr(' ', '_')
      @platform[:release] = cmd.stdout[/^ProductVersion:\s+(.+)$/, 1]
      @platform[:build] = cmd.stdout[/^BuildVersion:\s+(.+)$/, 1]
      # TODO: keep for now due to backwards compatibility with serverspec
      @platform[:family] = 'darwin'
      detect_darwin_arch
      true
    end

    def detect_darwin_arch
      @platform[:arch] = uname_m
    end
  end
end
