package com.shaunthomas999.java8.extensionMethods;

public class ExtensionMethodClass implements com.shaunthomas999.java8.extensionMethods.ExtensionMethodInterface {

    @Override
    public void printSomething() {
        System.out.println(this.getText());
        System.out.println(this.getSecondText());
    }

    public static void main(String[] args) {
        ExtensionMethodClass extensionMethodClass = new ExtensionMethodClass();
        extensionMethodClass.printSomething();


    }
}
