package com.shaunthomas999.basics.streams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Ref: https://www.baeldung.com/convert-input-stream-to-array-of-bytes
 */
public class InputStreamToByteArray {

    public static void main(String[] args) throws IOException {

        String someString = "Hello Shaun!";
        InputStream initialStream = new ByteArrayInputStream(someString.getBytes(UTF_8));

        byte[] targetArray = new byte[initialStream.available()];
        initialStream.read(targetArray);

        String result = new String(targetArray);
        System.out.println(result);
    }
}
