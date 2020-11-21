package com.shaunthomas999.java8.functionalInterface;

/**
 * Created by shaunthomas on 02/08/16.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F value);
}
