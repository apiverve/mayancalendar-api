# Mayan Calendar API - Ruby Gem

Mayan Calendar converts Gregorian dates to the ancient Mayan calendar system. Returns the Long Count, Tzolkin (260-day sacred calendar), and Haab (365-day civil calendar) dates.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_mayancalendar'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_mayancalendar
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_mayancalendar'

# Initialize the client
client = APIVerve::Mayancalendar::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ date: "2024-12-21" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ date: "2024-12-21" })
  puts response["data"]
rescue APIVerve::Mayancalendar::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Mayancalendar::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Mayancalendar::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "gregorian": "2024-12-21",
    "longCount": {
      "formatted": "13.0.12.3.3",
      "baktun": 13,
      "katun": 0,
      "tun": 12,
      "winal": 3,
      "kin": 3
    },
    "tzolkin": {
      "number": 6,
      "dayName": "Akbal",
      "formatted": "6 Akbal"
    },
    "haab": {
      "day": 6,
      "monthName": "Kankin",
      "formatted": "6 Kankin"
    },
    "calendarRound": "6 Akbal 6 Kankin",
    "daysSinceEpoch": 1876383
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/mayancalendar?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/mayancalendar?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/mayancalendar?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
