/// Response models for the Mayan Calendar API.

/// API Response wrapper.
class MayancalendarResponse {
  final String status;
  final dynamic error;
  final MayancalendarData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  MayancalendarResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory MayancalendarResponse.fromJson(Map<String, dynamic> json) => MayancalendarResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? MayancalendarData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Mayan Calendar API.

class MayancalendarData {
  String? gregorian;
  MayancalendarDataLongcount? longCount;
  MayancalendarDataTzolkin? tzolkin;
  MayancalendarDataHaab? haab;
  String? calendarRound;
  num? daysSinceEpoch;

  MayancalendarData({
    this.gregorian,
    this.longCount,
    this.tzolkin,
    this.haab,
    this.calendarRound,
    this.daysSinceEpoch,
  });

  factory MayancalendarData.fromJson(Map<String, dynamic> json) => MayancalendarData(
      gregorian: json['gregorian'],
      longCount: json['longCount'] != null ? MayancalendarDataLongcount.fromJson(json['longCount']) : null,
      tzolkin: json['tzolkin'] != null ? MayancalendarDataTzolkin.fromJson(json['tzolkin']) : null,
      haab: json['haab'] != null ? MayancalendarDataHaab.fromJson(json['haab']) : null,
      calendarRound: json['calendarRound'],
      daysSinceEpoch: json['daysSinceEpoch'],
    );
}

class MayancalendarDataLongcount {
  String? formatted;
  num? baktun;
  num? katun;
  num? tun;
  num? winal;
  num? kin;

  MayancalendarDataLongcount({
    this.formatted,
    this.baktun,
    this.katun,
    this.tun,
    this.winal,
    this.kin,
  });

  factory MayancalendarDataLongcount.fromJson(Map<String, dynamic> json) => MayancalendarDataLongcount(
      formatted: json['formatted'],
      baktun: json['baktun'],
      katun: json['katun'],
      tun: json['tun'],
      winal: json['winal'],
      kin: json['kin'],
    );
}

class MayancalendarDataTzolkin {
  num? number;
  String? dayName;
  String? formatted;

  MayancalendarDataTzolkin({
    this.number,
    this.dayName,
    this.formatted,
  });

  factory MayancalendarDataTzolkin.fromJson(Map<String, dynamic> json) => MayancalendarDataTzolkin(
      number: json['number'],
      dayName: json['dayName'],
      formatted: json['formatted'],
    );
}

class MayancalendarDataHaab {
  num? day;
  String? monthName;
  String? formatted;

  MayancalendarDataHaab({
    this.day,
    this.monthName,
    this.formatted,
  });

  factory MayancalendarDataHaab.fromJson(Map<String, dynamic> json) => MayancalendarDataHaab(
      day: json['day'],
      monthName: json['monthName'],
      formatted: json['formatted'],
    );
}

class MayancalendarRequest {
  String date;

  MayancalendarRequest({
    required this.date,
  });

  Map<String, dynamic> toJson() => {
      'date': date,
    };
}
