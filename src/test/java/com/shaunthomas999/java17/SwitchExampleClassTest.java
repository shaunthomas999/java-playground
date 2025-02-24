package com.shaunthomas999.java17;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SwitchExampleClassTest {

  @Test
  void shouldReturnInteger() {
    assertEquals(1, SwitchExampleClass.getInt("b"));
    assertEquals(2, SwitchExampleClass.getInt("c"));
  }

  @Test
  void shouldReturnAlphabet() {
    assertEquals("c", SwitchExampleClass.getAlphabet(5));
  }
}
