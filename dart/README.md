# Mayan Calendar API - Dart/Flutter Client

Mayan Calendar converts Gregorian dates to the ancient Mayan calendar system. Returns the Long Count, Tzolkin (260-day sacred calendar), and Haab (365-day civil calendar) dates.

[![pub package](https://img.shields.io/pub/v/apiverve_mayancalendar.svg)](https://pub.dev/packages/apiverve_mayancalendar)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Mayan Calendar API](https://apiverve.com/marketplace/mayancalendar?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_mayancalendar: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_mayancalendar/apiverve_mayancalendar.dart';

void main() async {
  final client = MayancalendarClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'date': '2024-12-21'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Mayan Calendar API](https://apiverve.com/marketplace/mayancalendar?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/mayancalendar](https://docs.apiverve.com/ref/mayancalendar?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
