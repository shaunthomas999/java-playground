package com.shaunthomas999.java17;

import java.util.Objects;

public record RecordExample2(String name, int age) {
  public RecordExample2 {
    Objects.requireNonNull(name);
  }

  public RecordExample2(String name) {
    this(name, 0);
  }
}
