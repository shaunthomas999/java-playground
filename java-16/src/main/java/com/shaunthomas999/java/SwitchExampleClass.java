package com.shaunthomas999.java;

public final class SwitchExampleClass {
  static int getInt(String alphabet) {
    return switch (alphabet) {
      case "a", "b":
        yield 1;
      case "c": {
        System.out.println("test-01");
        yield 2;
      }
      case "d", "e":
        yield 3;
      default:
        yield -1;
    };
  }

  static String getAlphabet(int number) {
    return switch (number) {
      case 1, 2 -> "a";
      case 3 -> "b";
      case 4, 5 -> "c";
      default -> "z";
    };
  }
}
