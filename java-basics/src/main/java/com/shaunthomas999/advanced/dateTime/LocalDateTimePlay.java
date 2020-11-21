package com.shaunthomas999.advanced.dateTime;

import lombok.val;

import java.time.*;

public class LocalDateTimePlay {

  public static void main(String[] args) {
    LocalDate localDate = LocalDate.parse("2500-10-02");
    System.out.println(localDate.toString());

    val localDateTime = LocalDateTime.of(2019, 2, 14, 10, 51, 52);
    System.out.println(localDateTime);

    val zoneId = ZoneId.of("Europe/Amsterdam");
    val zoneOffset = zoneId.getRules().getOffset(localDateTime);
    System.out.println(OffsetDateTime.of(localDateTime, zoneOffset));

    System.out.println(OffsetDateTime.of(localDateTime, ZoneOffset.UTC));
  }
}
