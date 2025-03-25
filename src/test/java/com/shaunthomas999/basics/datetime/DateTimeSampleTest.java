package com.shaunthomas999.basics.datetime;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateTimeSampleTest {

  @Test
  void testGetClassicDate() throws ParseException {
    var date = DateTimeSample.getClassicDate("2025-03-25");
    assertNotNull(date);

    // Classic Date: Tue Mar 25 00:00:00 CET 2025
    System.out.println("Classic Date: " + date);
  }
}
