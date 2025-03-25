package com.shaunthomas999.basics.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeSample {

  private DateTimeSample() {}

  public static Date getClassicDate(String date) throws ParseException {
    final var formatter = new SimpleDateFormat("yyyy-MM-dd");
    return formatter.parse(date);
  }
}
