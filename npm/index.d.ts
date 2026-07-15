declare module '@apiverve/mayancalendar' {
  export interface mayancalendarOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface mayancalendarResponse {
    status: string;
    error: string | null;
    data: MayanCalendarData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface MayanCalendarData {
      gregorian:      Date | null;
      longCount:      LongCount;
      tzolkin:        Tzolkin;
      haab:           Haab;
      calendarRound:  null | string;
      daysSinceEpoch: number | null;
  }
  
  interface Haab {
      day:       number | null;
      monthName: null | string;
      formatted: null | string;
  }
  
  interface LongCount {
      formatted: null | string;
      baktun:    number | null;
      katun:     number | null;
      tun:       number | null;
      winal:     number | null;
      kin:       number | null;
  }
  
  interface Tzolkin {
      number:    number | null;
      dayName:   null | string;
      formatted: null | string;
  }

  export default class mayancalendarWrapper {
    constructor(options: mayancalendarOptions);

    execute(callback: (error: any, data: mayancalendarResponse | null) => void): Promise<mayancalendarResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: mayancalendarResponse | null) => void): Promise<mayancalendarResponse>;
    execute(query?: Record<string, any>): Promise<mayancalendarResponse>;
  }
}
