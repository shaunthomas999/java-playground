package com.shaunthomas999.advanced.collections;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {
  public class SomeClass01 {
    public String name;
    public String age;

    public SomeClass01(String name, String age) {
      this.name = name;
      this.age = age;
    }
  }

  public class ArrayListExtended extends ArrayList<SomeClass01> {

  }

  @Test
  public void test01() {
    SomeClass01 someClass01 = new SomeClass01("Someone", "22");

    ArrayListExtended arrayListExtended = new ArrayListExtended();
    arrayListExtended.add(someClass01);
  }
}
