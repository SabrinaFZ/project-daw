# -*- encoding: utf-8 -*-
# stub: appbundler 0.10.0 ruby lib

Gem::Specification.new do |s|
  s.name = "appbundler".freeze
  s.version = "0.10.0"

  s.required_rubygems_version = Gem::Requirement.new(">= 0".freeze) if s.respond_to? :required_rubygems_version=
  s.require_paths = ["lib".freeze]
  s.authors = ["Dan DeLeo".freeze]
  s.date = "2017-05-26"
  s.description = "Extracts a dependency solution from bundler's Gemfile.lock to speed gem activation".freeze
  s.email = ["dan@chef.io".freeze]
  s.executables = ["appbundler".freeze]
  s.files = ["bin/appbundler".freeze]
  s.homepage = "https://github.com/chef/appbundler".freeze
  s.licenses = ["Apache-2.0".freeze]
  s.required_ruby_version = Gem::Requirement.new(">= 2.2.0".freeze)
  s.rubygems_version = "2.6.11".freeze
  s.summary = "Extracts a dependency solution from bundler's Gemfile.lock to speed gem activation".freeze

  s.installed_by_version = "2.6.11" if s.respond_to? :installed_by_version

  if s.respond_to? :specification_version then
    s.specification_version = 4

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_development_dependency(%q<rake>.freeze, [">= 0"])
      s.add_development_dependency(%q<rspec>.freeze, ["~> 3.0"])
      s.add_development_dependency(%q<pry>.freeze, [">= 0"])
      s.add_development_dependency(%q<mixlib-shellout>.freeze, ["~> 2.0"])
      s.add_runtime_dependency(%q<mixlib-cli>.freeze, ["~> 1.4"])
    else
      s.add_dependency(%q<rake>.freeze, [">= 0"])
      s.add_dependency(%q<rspec>.freeze, ["~> 3.0"])
      s.add_dependency(%q<pry>.freeze, [">= 0"])
      s.add_dependency(%q<mixlib-shellout>.freeze, ["~> 2.0"])
      s.add_dependency(%q<mixlib-cli>.freeze, ["~> 1.4"])
    end
  else
    s.add_dependency(%q<rake>.freeze, [">= 0"])
    s.add_dependency(%q<rspec>.freeze, ["~> 3.0"])
    s.add_dependency(%q<pry>.freeze, [">= 0"])
    s.add_dependency(%q<mixlib-shellout>.freeze, ["~> 2.0"])
    s.add_dependency(%q<mixlib-cli>.freeze, ["~> 1.4"])
  end
end
