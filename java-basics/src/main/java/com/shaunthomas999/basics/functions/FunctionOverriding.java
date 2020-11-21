package com.shaunthomas999.basics.functions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class FunctionOverriding {

  public static boolean check(String something) {
    log.info("Inside string one");
    return something.contains("shaun");
  }

  public static boolean check(Integer something) {
    log.info("Inside integer one");
    return something > 5;
  }
}
