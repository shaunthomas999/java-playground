package com.shaunthomas999.java8.extensionMethods;

public interface ExtensionMethodInterface {

    void printSomething();

    default String getText() {
        return "Print this";
    }

    default String getSecondText() {
        return "Second text";
    }
}
