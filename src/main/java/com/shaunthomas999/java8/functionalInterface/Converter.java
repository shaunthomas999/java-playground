package com.shaunthomas999.java8.functionalInterface;

/**
  A functional interface is an interface with exactly one abstract method.
  It can have any number of default or static methods.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F value);
}
