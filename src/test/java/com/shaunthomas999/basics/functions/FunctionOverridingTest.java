package com.shaunthomas999.basics.functions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
//        .forEach(r -> System.out.println("Result " + r));

    assertTrue(true);
  }
}
