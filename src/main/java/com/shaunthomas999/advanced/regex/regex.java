package com.shaunthomas999.advanced.regex;

public class regex {

    public static void main(String[] args) {
        String test = "1.3.39";

        if(test.matches("(\\d+\\.){2}\\d+\\S*")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
