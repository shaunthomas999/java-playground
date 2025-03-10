package com.shaunthomas999.java17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatternMatchingSwitchTest {

  @Test
  void handleObjectTest() {
    var patternMatchingSwitch = new PatternMatchingSwitch();
    assertEquals("String: Hello, World!", patternMatchingSwitch.handleObject("Hello, World!"));
    assertEquals("Null value", patternMatchingSwitch.handleObject(null));
  }

  @Test
  void describePointTest() {
    var patternMatchingSwitch = new PatternMatchingSwitch();
    assertEquals("Point at (10, 20)", patternMatchingSwitch.describePoint(new PatternMatchingSwitch.Point(10, 20)));
    assertEquals("Not a point", patternMatchingSwitch.describePoint("Shaun"));
  }
}
