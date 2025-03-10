package com.shaunthomas999.java17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordExampleTest {

  @Test
  void testRecord() {
    // Canonical constructor
    var recordExample = new RecordExample("Shaun", 37);

    // Public accessor
    assertEquals("Shaun", recordExample.name());
    assertEquals(37, recordExample.age());
  }
}
