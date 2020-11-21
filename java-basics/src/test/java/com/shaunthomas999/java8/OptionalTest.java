package com.shaunthomas999.java8;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

  @Data
  class MyTestClass {
    private final String name;
    private final Integer age;
  }

  /**
   * Optional.ofNullable()
   */
  @Test
  public void test1() {
    MyTestClass myTestClass = null;

    MyTestClass myTestClass2 = Optional.ofNullable(myTestClass)
                                .orElse(new MyTestClass("Sachin", 45));

    System.out.println(myTestClass2);
  }

  /**
   * Optional.of()
   */
  @Test(expected = NullPointerException.class)
  public void test2() {
    MyTestClass myTestClass = null;

    MyTestClass myTestClass2 = Optional.of(myTestClass)
        .orElse(new MyTestClass("Sachin", 45));
  }

  /**
   * Nested nulls with initial data null
   */
  @Test(expected = RuntimeException.class)
  public void test03() {
    MyTestClass myTestClass = null;

    MyTestClass myTestClass2 = Optional.ofNullable(myTestClass)
        .map(d -> returnsNullMethod())
        .orElseThrow(RuntimeException::new);
  }

  /**
   * Nested nulls with intermediate null
   */
  @Test(expected = RuntimeException.class)
  public void test04() {
    MyTestClass myTestClass = new MyTestClass("Sachin", 45);

    MyTestClass myTestClass2 = Optional.ofNullable(myTestClass)
        .map(d -> returnsNullMethod())
        .orElseThrow(RuntimeException::new);
  }

  public static MyTestClass returnsNullMethod() {
    return null;
  }
}
