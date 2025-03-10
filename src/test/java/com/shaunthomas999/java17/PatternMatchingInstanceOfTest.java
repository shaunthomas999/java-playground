package com.shaunthomas999.java17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatternMatchingInstanceOfTest {

  @Test
  void checkPatternTest() {
    var patternMatchingInstanceOf = new PatternMatchingInstanceOf();
    assertEquals("Hello, World!", patternMatchingInstanceOf.checkPattern());
  }

}
