package com.shaunthomas999.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        lines.stream()
            .filter(line -> !"mkyong".equals(line))
            .collect(Collectors.toList())
            .forEach(System.out::println);
    }
}
