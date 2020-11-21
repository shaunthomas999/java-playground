package com.shaunthomas999.libraries.jodaTime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.junit.Test;

public class JodaTimeTest {

  @Test
  public void dateTimeTest() {
    DateTime dateTime01 = DateTime.now(DateTimeZone.UTC);

    System.out.println(dateTime01); // 2019-03-14T15:25:46.085Z

    DateTime dateTime02 = new DateTime(1487954316204L);

    System.out.println(dateTime02); // 2017-02-24T17:38:36.204+01:00 <- Time zone also
  }

  @Test
  public void instantTest() {
    Instant instant = Instant.now();

    System.out.println(instant); // 2019-03-14T15:36:21.941Z

    System.out.println(instant.getMillis()); // 1552577833998
  }

  @Test
  public void instantComparisonTest() {
    Instant instant01 = Instant.ofEpochMilli(1487954316204L);

    System.out.println(instant01); // 2017-02-24T16:38:36.204Z

    Instant instant02 = new Instant(1487954316204L);

    System.out.println(instant02); // 2017-02-24T16:38:36.204Z

    java.time.Instant instant03 = java.time.Instant.ofEpochMilli(1487954316204L); // java 8

    System.out.println(instant03); // 2017-02-24T16:38:36.204Z
  }
}
