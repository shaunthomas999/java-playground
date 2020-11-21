package com.shaunthomas999.java8.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.shaunthomas999.java8.optional.OptionalSample.giveMeBack;
import static com.shaunthomas999.java8.optional.OptionalSample.throwNPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionalSampleTest {

  @Test
  void testNull() {
    Optional<String> result = Optional.ofNullable(giveMeBack(null)).map(s -> s.concat("123"));
    assertThat(result).isEmpty();
  }

  @Test
  void testNonNull() {
    Optional<String> result1 = Optional.of(giveMeBack("Shaun")).map(s -> s.concat("123"));
    assertThat(result1).isNotEmpty();
    assertThat(result1.get()).isEqualTo("Shaun123");

    Optional<String> result2 = Optional.ofNullable(giveMeBack("Shaun")).map(s -> s.concat("123"));
    assertThat(result2).isNotEmpty();
    assertThat(result2.get()).isEqualTo("Shaun123");
  }

  @Test
  void testNPE() {
    assertThrows(NullPointerException.class,
        () -> Optional.ofNullable(throwNPE(null)));
  }
}
