package com.shaunthomas999.basics.functions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class FunctionOverridingTest {

  @Test
  void testOverriding() {
    List<Object> list = new ArrayList<Object>();
    list.add("Shaun");
    list.add(72);
    list.add(null);

    // Can't do this!
//    list.stream()
//        .map(i -> FunctionOverriding.check((String) i))
//        .forEach(r -> log.info("Result " + r));

    assertTrue(true);
  }
}
