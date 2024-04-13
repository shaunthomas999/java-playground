package com.shaunthomas999.java21;

import static java.lang.StringTemplate.STR;

/**
 * Preview feature
 */
public class FStringTemplates {

  public void example_01() {
    String language = "Java";
    String version = "21";

    // Will display "Discover Java 21 release!"
    String template = STR."Discover \{language} \{version} release!";
    System.out.println(template);

    // String will not process variables: "Discover \{language} \{version} release!"
//    String regular = "Discover \{language} \{version} release!";

  }
}
