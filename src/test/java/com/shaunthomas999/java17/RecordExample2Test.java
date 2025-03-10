package com.shaunthomas999.java17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordExample2Test {

  @Test
  void testRecord() throws NullPointerException {
    assertThrows(NullPointerException.class, () -> new RecordExample2(null, 37));
  }
}
