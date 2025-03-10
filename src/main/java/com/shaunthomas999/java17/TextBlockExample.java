package com.shaunthomas999.java17;

/**
 * https://www.tutorialspoint.com/java/java_text_blocks.htm
 */
public class TextBlockExample {

  public static final String HTML = """
    <html>
    <body>
    <h1>Hello, World!</h1>
    </body>
    </html>
    """;

  public static final String TEXT_BLOCK_JSON = """
         {
            "name" : "%s",
            "RollNO" : "%s"
         }
         """.formatted("Shaun", "37");
}
