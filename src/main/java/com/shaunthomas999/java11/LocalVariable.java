package com.shaunthomas999.java11;

public class LocalVariable {

  public void someMethod() {
    var firstName = "Shaun";
    final var lastName = "Thomas";
    final var yearOfBirth = 1987;

    System.out.println(firstName + " " +lastName + " is born on " + yearOfBirth);
  }
}
