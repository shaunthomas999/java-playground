package com.shaunthomas999.advanced.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadInterruptSampleTest {

  @Test
  void runMethod() {
    ThreadInterruptSample.execute();

    assertTrue(true);
  }
}
