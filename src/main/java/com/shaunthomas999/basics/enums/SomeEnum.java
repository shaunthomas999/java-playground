package com.shaunthomas999.basics.enums;

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
public enum SomeEnum {
  A("a"),
  B("b"),
  C("c"),
  ;

  private final String value;

  SomeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
