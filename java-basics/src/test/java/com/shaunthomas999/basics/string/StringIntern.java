package com.shaunthomas999.basics.string;

import org.junit.Test;

/**
 * - String intern is used to make sure that string with same content are stored in the same memory location.
 * - Contents are stored in heap
 * - The intern() method should be used on strings constructed with new String() in order to compare them by == operator
 * - Java interns string internally as well
 *
 * Reference
 * - https://dzone.com/articles/string-interning-what-why-and
 * - https://stackoverflow.com/questions/10578984/what-is-java-string-interning
 */
public class StringIntern {

  @Test
  public void intern() {
    String s1 = "Test";
    String s2 = "Test";
    String s3 = new String("Test");
    final String s4 = s3.intern();

    System.out.println(s1 == s2);
    System.out.println(s2 == s3);
    System.out.println(s3 == s4);
    System.out.println(s1 == s3);
    System.out.println(s1 == s4);
    System.out.println(s1.equals(s2));
    System.out.println(s2.equals(s3));
    System.out.println(s3.equals(s4));
    System.out.println(s1.equals(s4));
    System.out.println(s1.equals(s3));
  }
}
