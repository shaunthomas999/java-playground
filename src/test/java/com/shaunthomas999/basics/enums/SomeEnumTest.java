package com.shaunthomas999.basics.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SomeEnumTest {

  @Test
  void shouldConvertString() {
    assertThat(SomeEnum.A.getValue()).isEqualTo("a");
    assertThat(SomeEnum.A.name()).isEqualTo("A");
  }

  @Test
  void testValueOf() {
    assertThrows(IllegalArgumentException.class, () -> SomeEnum.valueOf("c"));
  }

  @Test
  void testGetOrdinal() {
    assertThat(SomeEnum.B.ordinal()).isEqualTo(1);
  }
}
