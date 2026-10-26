# frozen_string_literal: true

Gem::Specification.new do |spec|
  spec.name          = "apiverve_mayancalendar"
  spec.version       = "1.2.3"
  spec.authors       = ["APIVerve"]
  spec.email         = ["hello@apiverve.com"]

  spec.summary       = "Mayan Calendar API - Ruby Client"
  spec.description   = "Mayan Calendar converts Gregorian dates to the ancient Mayan calendar system. Returns the Long Count, Tzolkin (260-day sacred calendar), and Haab (365-day civil calendar) dates."
  spec.homepage      = "https://apiverve.com/marketplace/mayancalendar?utm_source=ruby&utm_medium=referral&utm_content=homepage"
  spec.license       = "MIT"
  spec.required_ruby_version = ">= 2.7.0"

  spec.metadata["homepage_uri"] = spec.homepage
  spec.metadata["source_code_uri"] = "https://github.com/apiverve/mayancalendar-API/tree/main/ruby"
  spec.metadata["changelog_uri"] = "https://apiverve.com/changelog"
  spec.metadata["documentation_uri"] = "https://docs.apiverve.com/ref/mayancalendar"

  spec.files = Dir.glob("{lib}/**/*") + %w[README.md LICENSE]
  spec.require_paths = ["lib"]

  spec.add_dependency "faraday", ">= 1.0", "< 3.0"
  spec.add_dependency "faraday-multipart", "~> 1.0"
  spec.add_dependency "json", "~> 2.0"
end
