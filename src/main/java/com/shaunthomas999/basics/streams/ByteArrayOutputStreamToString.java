package com.shaunthomas999.basics.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ByteArrayOutputStreamToString {

    public static void main(String[] args) throws IOException {
        String originalString = "This is a beautiful world!!!";
        InputStream inputStream = new ByteArrayInputStream(originalString.getBytes());

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] byteArray = buffer.toByteArray();

        String text = new String(byteArray, StandardCharsets.UTF_8);

        assert text.equals(originalString);

        System.out.println(text);
        System.out.println(originalString);
    }
}
