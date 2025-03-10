package com.shaunthomas999.java17;

public class PatternMatchingInstanceOf {

  public String checkPattern() {
    var obj = "Hello, World!";

    if (obj instanceof String s && s.length() > 5) {
      System.out.println(s);
      return s;
    }

    return "";
  }
}
