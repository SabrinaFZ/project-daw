# -*- encoding: utf-8 -*-
# stub: bundler-audit 0.5.0 ruby lib

Gem::Specification.new do |s|
  s.name = "bundler-audit".freeze
  s.version = "0.5.0"

  s.required_rubygems_version = Gem::Requirement.new(">= 1.8.0".freeze) if s.respond_to? :required_rubygems_version=
  s.require_paths = ["lib".freeze]
  s.authors = ["Postmodern".freeze]
  s.date = "2017-05-26"
  s.description = "bundler-audit provides patch-level verification for Bundled apps.".freeze
  s.email = "postmodern.mod3@gmail.com".freeze
  s.executables = ["bundle-audit".freeze, "bundler-audit".freeze]
  s.extra_rdoc_files = ["COPYING.txt".freeze, "ChangeLog.md".freeze, "README.md".freeze]
  s.files = [".document".freeze, ".gitignore".freeze, ".gitmodules".freeze, ".rspec".freeze, ".travis.yml".freeze, ".yardopts".freeze, "COPYING.txt".freeze, "ChangeLog.md".freeze, "Gemfile".freeze, "README.md".freeze, "Rakefile".freeze, "bin/bundle-audit".freeze, "bin/bundler-audit".freeze, "bundler-audit.gemspec".freeze, "data/ruby-advisory-db".freeze, "data/ruby-advisory-db.ts".freeze, "gemspec.yml".freeze, "lib/bundler/audit.rb".freeze, "lib/bundler/audit/advisory.rb".freeze, "lib/bundler/audit/cli.rb".freeze, "lib/bundler/audit/database.rb".freeze, "lib/bundler/audit/scanner.rb".freeze, "lib/bundler/audit/task.rb".freeze, "lib/bundler/audit/version.rb".freeze, "spec/advisory_spec.rb".freeze, "spec/audit_spec.rb".freeze, "spec/bundle/insecure_sources/Gemfile".freeze, "spec/bundle/secure/Gemfile".freeze, "spec/bundle/unpatched_gems/Gemfile".freeze, "spec/cli_spec.rb".freeze, "spec/database_spec.rb".freeze, "spec/fixtures/not_a_hash.yml".freeze, "spec/integration_spec.rb".freeze, "spec/scanner_spec.rb".freeze, "spec/spec_helper.rb".freeze]
  s.homepage = "https://github.com/rubysec/bundler-audit#readme".freeze
  s.licenses = ["GPL-3.0+".freeze]
  s.required_ruby_version = Gem::Requirement.new(">= 1.9.3".freeze)
  s.rubygems_version = "2.6.11".freeze
  s.summary = "Patch-level verification for Bundler".freeze

  if s.respond_to? :specification_version then
    s.specification_version = 4

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<thor>.freeze, ["~> 0.18"])
      s.add_runtime_dependency(%q<bundler>.freeze, ["~> 1.2"])
    else
      s.add_dependency(%q<thor>.freeze, ["~> 0.18"])
      s.add_dependency(%q<bundler>.freeze, ["~> 1.2"])
    end
  else
    s.add_dependency(%q<thor>.freeze, ["~> 0.18"])
    s.add_dependency(%q<bundler>.freeze, ["~> 1.2"])
  end
end
