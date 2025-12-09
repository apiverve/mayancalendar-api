// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     MayanCalendarData data = Converter.fromJsonString(jsonString);

package com.apiverve.mayancalendar.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static MayanCalendarData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(MayanCalendarData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(MayanCalendarData.class);
        writer = mapper.writerFor(MayanCalendarData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// MayanCalendarData.java

package com.apiverve.mayancalendar.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class MayanCalendarData {
    private LocalDate gregorian;
    private LongCount longCount;
    private Tzolkin tzolkin;
    private Haab haab;
    private String calendarRound;
    private long daysSinceEpoch;

    @JsonProperty("gregorian")
    public LocalDate getGregorian() { return gregorian; }
    @JsonProperty("gregorian")
    public void setGregorian(LocalDate value) { this.gregorian = value; }

    @JsonProperty("longCount")
    public LongCount getLongCount() { return longCount; }
    @JsonProperty("longCount")
    public void setLongCount(LongCount value) { this.longCount = value; }

    @JsonProperty("tzolkin")
    public Tzolkin getTzolkin() { return tzolkin; }
    @JsonProperty("tzolkin")
    public void setTzolkin(Tzolkin value) { this.tzolkin = value; }

    @JsonProperty("haab")
    public Haab getHaab() { return haab; }
    @JsonProperty("haab")
    public void setHaab(Haab value) { this.haab = value; }

    @JsonProperty("calendarRound")
    public String getCalendarRound() { return calendarRound; }
    @JsonProperty("calendarRound")
    public void setCalendarRound(String value) { this.calendarRound = value; }

    @JsonProperty("daysSinceEpoch")
    public long getDaysSinceEpoch() { return daysSinceEpoch; }
    @JsonProperty("daysSinceEpoch")
    public void setDaysSinceEpoch(long value) { this.daysSinceEpoch = value; }
}

// Haab.java

package com.apiverve.mayancalendar.data;

import com.fasterxml.jackson.annotation.*;

public class Haab {
    private long day;
    private String monthName;
    private String formatted;

    @JsonProperty("day")
    public long getDay() { return day; }
    @JsonProperty("day")
    public void setDay(long value) { this.day = value; }

    @JsonProperty("monthName")
    public String getMonthName() { return monthName; }
    @JsonProperty("monthName")
    public void setMonthName(String value) { this.monthName = value; }

    @JsonProperty("formatted")
    public String getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(String value) { this.formatted = value; }
}

// LongCount.java

package com.apiverve.mayancalendar.data;

import com.fasterxml.jackson.annotation.*;

public class LongCount {
    private String formatted;
    private long baktun;
    private long katun;
    private long tun;
    private long winal;
    private long kin;

    @JsonProperty("formatted")
    public String getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(String value) { this.formatted = value; }

    @JsonProperty("baktun")
    public long getBaktun() { return baktun; }
    @JsonProperty("baktun")
    public void setBaktun(long value) { this.baktun = value; }

    @JsonProperty("katun")
    public long getKatun() { return katun; }
    @JsonProperty("katun")
    public void setKatun(long value) { this.katun = value; }

    @JsonProperty("tun")
    public long getTun() { return tun; }
    @JsonProperty("tun")
    public void setTun(long value) { this.tun = value; }

    @JsonProperty("winal")
    public long getWinal() { return winal; }
    @JsonProperty("winal")
    public void setWinal(long value) { this.winal = value; }

    @JsonProperty("kin")
    public long getKin() { return kin; }
    @JsonProperty("kin")
    public void setKin(long value) { this.kin = value; }
}

// Tzolkin.java

package com.apiverve.mayancalendar.data;

import com.fasterxml.jackson.annotation.*;

public class Tzolkin {
    private long number;
    private String dayName;
    private String formatted;

    @JsonProperty("number")
    public long getNumber() { return number; }
    @JsonProperty("number")
    public void setNumber(long value) { this.number = value; }

    @JsonProperty("dayName")
    public String getDayName() { return dayName; }
    @JsonProperty("dayName")
    public void setDayName(String value) { this.dayName = value; }

    @JsonProperty("formatted")
    public String getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(String value) { this.formatted = value; }
}