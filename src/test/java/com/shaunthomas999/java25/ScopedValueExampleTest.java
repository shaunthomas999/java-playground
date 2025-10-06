package com.shaunthomas999.java25;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ScopedValueExampleTest {

  @Test
  void process() {
    assertThrows(NoSuchElementException.class, () -> new ScopedValueExample().process());
  }
}
