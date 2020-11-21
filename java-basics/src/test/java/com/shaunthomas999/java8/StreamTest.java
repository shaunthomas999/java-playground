package com.shaunthomas999.java8;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {

  @Test
  public void peek() {
    /*
       Peek goes through each element in stream and perform the requested action.
       Here it is sout
     */
    Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());
  }

  @Test
  public void noMatch() {

    List<Integer> result = Stream.of(1, 2, 3, 4)
        .filter(e -> e > 5)
        .collect(Collectors.toList());

    assertThat(result).isEmpty();
  }
}
