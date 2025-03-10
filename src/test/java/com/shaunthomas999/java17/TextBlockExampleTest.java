package com.shaunthomas999.java17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TextBlockExampleTest {

  @Test
  void textBlockTest() {
    System.out.println(TextBlockExample.HTML);
    assertTrue(TextBlockExample.HTML.contains("</html>"));
  }

  @Test
  void textBlockJsonTest() {
    System.out.println(TextBlockExample.TEXT_BLOCK_JSON);
    assertTrue(TextBlockExample.TEXT_BLOCK_JSON.contains("Shaun"));
  }
}
