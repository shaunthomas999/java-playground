package com.shaunthomas999.basics.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Reference:
 *  https://www.tutorialspoint.com/java/lang/java_lang_enum.htm
 *  http://tutorials.jenkov.com/java/enums.html
 *  https://stackoverflow.com/questions/609860/convert-from-enum-ordinal-to-enum-type [warning inside]
 *
 * Methods:
 * - name()
 * - ordinal()
 */
@Getter
@RequiredArgsConstructor
public enum SomeEnum {
  A("a"),
  B("b"),
  C("c"),
  ;

  private final String value;
}
