declare module '@apiverve/mayancalendar' {
  export interface mayancalendarOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface mayancalendarResponse {
    status: string;
    error: string | null;
    data: MayanCalendarData;
    code?: number;
  }


  interface MayanCalendarData {
      gregorian:      Date;
      longCount:      LongCount;
      tzolkin:        Tzolkin;
      haab:           Haab;
      calendarRound:  string;
      daysSinceEpoch: number;
  }
  
  interface Haab {
      day:       number;
      monthName: string;
      formatted: string;
  }
  
  interface LongCount {
      formatted: string;
      baktun:    number;
      katun:     number;
      tun:       number;
      winal:     number;
      kin:       number;
  }
  
  interface Tzolkin {
      number:    number;
      dayName:   string;
      formatted: string;
  }

  export default class mayancalendarWrapper {
    constructor(options: mayancalendarOptions);

    execute(callback: (error: any, data: mayancalendarResponse | null) => void): Promise<mayancalendarResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: mayancalendarResponse | null) => void): Promise<mayancalendarResponse>;
    execute(query?: Record<string, any>): Promise<mayancalendarResponse>;
  }
}
