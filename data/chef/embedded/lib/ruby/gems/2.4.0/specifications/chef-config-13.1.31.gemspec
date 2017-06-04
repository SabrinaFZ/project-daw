# -*- encoding: utf-8 -*-
# stub: chef-config 13.1.31 ruby lib

Gem::Specification.new do |s|
  s.name = "chef-config"
  s.version = "13.1.31"

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.require_paths = ["lib"]
  s.authors = ["Adam Jacob"]
  s.date = "2017-05-26"
  s.email = ["adam@chef.io"]
  s.homepage = "https://github.com/chef/chef"
  s.licenses = ["Apache-2.0"]
  s.rubygems_version = "2.4.8"
  s.summary = "Chef's default configuration and config loading"

  s.installed_by_version = "2.4.8" if s.respond_to? :installed_by_version

  if s.respond_to? :specification_version then
    s.specification_version = 4

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<mixlib-shellout>, ["~> 2.0"])
      s.add_runtime_dependency(%q<mixlib-config>, ["~> 2.0"])
      s.add_runtime_dependency(%q<fuzzyurl>, [">= 0"])
      s.add_runtime_dependency(%q<addressable>, [">= 0"])
      s.add_development_dependency(%q<rake>, ["~> 10.0"])
      s.add_development_dependency(%q<rspec-core>, ["~> 3.2"])
      s.add_development_dependency(%q<rspec-expectations>, ["~> 3.2"])
      s.add_development_dependency(%q<rspec-mocks>, ["~> 3.2"])
    else
      s.add_dependency(%q<mixlib-shellout>, ["~> 2.0"])
      s.add_dependency(%q<mixlib-config>, ["~> 2.0"])
      s.add_dependency(%q<fuzzyurl>, [">= 0"])
      s.add_dependency(%q<addressable>, [">= 0"])
      s.add_dependency(%q<rake>, ["~> 10.0"])
      s.add_dependency(%q<rspec-core>, ["~> 3.2"])
      s.add_dependency(%q<rspec-expectations>, ["~> 3.2"])
      s.add_dependency(%q<rspec-mocks>, ["~> 3.2"])
    end
  else
    s.add_dependency(%q<mixlib-shellout>, ["~> 2.0"])
    s.add_dependency(%q<mixlib-config>, ["~> 2.0"])
    s.add_dependency(%q<fuzzyurl>, [">= 0"])
    s.add_dependency(%q<addressable>, [">= 0"])
    s.add_dependency(%q<rake>, ["~> 10.0"])
    s.add_dependency(%q<rspec-core>, ["~> 3.2"])
    s.add_dependency(%q<rspec-expectations>, ["~> 3.2"])
    s.add_dependency(%q<rspec-mocks>, ["~> 3.2"])
  end
end
