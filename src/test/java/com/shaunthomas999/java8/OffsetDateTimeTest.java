package com.shaunthomas999.java8;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class OffsetDateTimeTest {

  @Test
  public void offsetDateTimeTest() {
    OffsetDateTime offsetDateTime = OffsetDateTime.now();

    System.out.println(offsetDateTime); // 2019-03-15T13:13:33.255497+01:00
  }

  @Test
  public void instantTest() {
    OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(1487954316204L), ZoneId.of("UTC"));

    System.out.println(offsetDateTime); // 2017-02-24T16:38:36.204Z
  }

  @Test
  public void parseTest() {
    OffsetDateTime offsetDateTime = OffsetDateTime.now();

    System.out.println(offsetDateTime.toInstant().toEpochMilli()); // 1487954316204
  }
}
