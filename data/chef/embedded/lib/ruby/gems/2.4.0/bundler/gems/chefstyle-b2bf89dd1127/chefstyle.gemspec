# -*- encoding: utf-8 -*-
# stub: chefstyle 0.5.0 ruby lib

Gem::Specification.new do |s|
  s.name = "chefstyle".freeze
  s.version = "0.5.0"

  s.required_rubygems_version = Gem::Requirement.new(">= 0".freeze) if s.respond_to? :required_rubygems_version=
  s.require_paths = ["lib".freeze]
  s.authors = ["Thom May".freeze]
  s.date = "2017-05-26"
  s.email = ["thom@chef.io".freeze]
  s.executables = ["chefstyle".freeze]
  s.files = [".gitignore".freeze, ".rspec".freeze, ".travis.yml".freeze, "Gemfile".freeze, "LICENSE.txt".freeze, "README.md".freeze, "Rakefile".freeze, "bin/chefstyle".freeze, "chefstyle.gemspec".freeze, "config/chefstyle.yml".freeze, "config/default.yml".freeze, "config/disable_all.yml".freeze, "config/disabled.yml".freeze, "config/enabled.yml".freeze, "config/upstream.yml".freeze, "lib/chefstyle.rb".freeze, "lib/chefstyle/version.rb".freeze]
  s.homepage = "https://github.com/chef/chefstyle".freeze
  s.licenses = ["Apache-2.0".freeze]
  s.required_ruby_version = Gem::Requirement.new(">= 2.2".freeze)
  s.rubygems_version = "2.6.11".freeze
  s.summary = "Rubocop configuration for Chef's ruby projects".freeze

  if s.respond_to? :specification_version then
    s.specification_version = 4

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_development_dependency(%q<bundler>.freeze, ["~> 1.10"])
      s.add_development_dependency(%q<rake>.freeze, ["~> 12.0"])
      s.add_development_dependency(%q<rspec>.freeze, [">= 0"])
      s.add_runtime_dependency(%q<rubocop>.freeze, ["= 0.47.1"])
    else
      s.add_dependency(%q<bundler>.freeze, ["~> 1.10"])
      s.add_dependency(%q<rake>.freeze, ["~> 12.0"])
      s.add_dependency(%q<rspec>.freeze, [">= 0"])
      s.add_dependency(%q<rubocop>.freeze, ["= 0.47.1"])
    end
  else
    s.add_dependency(%q<bundler>.freeze, ["~> 1.10"])
    s.add_dependency(%q<rake>.freeze, ["~> 12.0"])
    s.add_dependency(%q<rspec>.freeze, [">= 0"])
    s.add_dependency(%q<rubocop>.freeze, ["= 0.47.1"])
  end
end
