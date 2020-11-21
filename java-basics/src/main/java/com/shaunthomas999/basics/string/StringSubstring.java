package com.shaunthomas999.basics.string;

public class StringSubstring {

    public String extract(String message) {
        return message.split("content:\n")[1];
    }
}
