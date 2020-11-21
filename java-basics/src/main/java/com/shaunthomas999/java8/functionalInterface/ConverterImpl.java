package com.shaunthomas999.java8.functionalInterface;

/**
 * Created by shaunthomas on 02/08/16.
 */
public class ConverterImpl {

    public static void main(String[] args) {
        ConverterImpl ConverterImpl = new ConverterImpl();
        ConverterImpl.callMe();
        ConverterImpl.callMeAlso();
    }

    private void callMe() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("456");
        System.out.println(converted);
    }

    private void callMeAlso() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("789");
        System.out.println(converted);
    }
}
