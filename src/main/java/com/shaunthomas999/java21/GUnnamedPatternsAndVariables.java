package com.shaunthomas999.java21;

import java.util.List;

public class GUnnamedPatternsAndVariables {

  public void example_01() {
    final var strings = List.of("Shaun", "Thomas");

    // let's consider you want to perform an action for each string but do not need the object itself
    int i = 0;
    for (String _ : strings) {
      // do action
      System.out.println(2 * i);
      i++;
    }
  }
}
