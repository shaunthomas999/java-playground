package com.shaunthomas999.java8.optional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalSample {

  public static String giveMeBack(String input) {
    return input;
  }

  public static String throwNPE(String input) {
    if (input == null) {
      throw new NullPointerException("NPE");
    }

    return input;
  }
}
