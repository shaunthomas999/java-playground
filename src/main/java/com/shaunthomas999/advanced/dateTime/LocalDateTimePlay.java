package com.shaunthomas999.advanced.dateTime;

import java.time.*;

public class LocalDateTimePlay {

  public static void main(String[] args) {
    LocalDate localDate = LocalDate.parse("2500-10-02");
    System.out.println(localDate.toString());

    var localDateTime = LocalDateTime.of(2019, 2, 14, 10, 51, 52);
    System.out.println(localDateTime);

    var zoneId = ZoneId.of("Europe/Amsterdam");
    var zoneOffset = zoneId.getRules().getOffset(localDateTime);
    System.out.println(OffsetDateTime.of(localDateTime, zoneOffset));

    System.out.println(OffsetDateTime.of(localDateTime, ZoneOffset.UTC));
  }
}
