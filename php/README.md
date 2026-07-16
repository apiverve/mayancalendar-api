# Mayan Calendar API - PHP Package

Mayan Calendar converts Gregorian dates to the ancient Mayan calendar system. Returns the Long Count, Tzolkin (260-day sacred calendar), and Haab (365-day civil calendar) dates.

## Installation

Install via Composer:

```bash
composer require apiverve/mayancalendar
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Mayancalendar\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['date' => '2024-12-21']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Mayancalendar\Client;
use APIVerve\Mayancalendar\Exceptions\APIException;
use APIVerve\Mayancalendar\Exceptions\ValidationException;

try {
    $response = $client->execute(['date' => '2024-12-21']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/mayancalendar?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/mayancalendar?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/mayancalendar?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
