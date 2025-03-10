package com.shaunthomas999.java17;

public class PatternMatchingSwitch {

  static String handleObject(Object obj) {
    return switch (obj) {
      case Integer i -> "Integer: " + i;
      case String s -> "String: " + s;
      case null -> "Null value";
      default -> "Other object: " + obj.getClass();
    };
  }

  record Point(int x, int y) {}

  static String describePoint(Object obj) {
    return switch (obj) {
      case Point(int x, int y) -> "Point at (" + x + ", " + y + ")";
      default -> "Not a point";
    };
  }
}
