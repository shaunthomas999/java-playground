package com.shaunthomas999.basics.functions;

public final class FunctionOverriding {

  public static boolean check(String something) {
    System.out.println("Inside string one");
    return something.contains("shaun");
  }

  public static boolean check(Integer something) {
    System.out.println("Inside integer one");
    return something > 5;
  }
}
