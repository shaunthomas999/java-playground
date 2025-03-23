package com.shaunthomas999.java24;

/*
  Flexible Constructor Bodies (Preview Feature)

  This feature is useful when a superclass calls a method from its constructor and you want to override this method in a subclass and want to access a field from the subclass inside this method. Previously, the subclass field would not be initialized when the method was called from the superclass constructor. Now it is possible to initialize the field and prevent surprises.

  https://blog.jetbrains.com/idea/2025/03/java-24-and-intellij-idea/#flexible-constructor-bodies
 */
public class CFlexibleConstructorBodies {

  abstract class Action {
    public Action() {
      System.out.println("performing " + getText());
    }
    public abstract String getText();
  }
  class DoubleAction extends Action {
    private final String text;
    private DoubleAction(String text) {
      this.text = text; // this did not compile before Java 23 with preview features enabled.
      super();
    }
    @Override public String getText() {
      return text + text;
    }
  }
}
