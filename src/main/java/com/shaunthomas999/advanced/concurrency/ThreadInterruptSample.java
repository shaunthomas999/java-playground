package com.shaunthomas999.advanced.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * See https://www.baeldung.com/java-delay-code-execution
 */
public final class ThreadInterruptSample {

  public static boolean execute() {
    System.out.println("1");

    try {
      TimeUnit.SECONDS.sleep(3);
      System.out.println("2");
    } catch (InterruptedException ie) {
      System.out.println("3");
      Thread.currentThread().interrupt();
      System.out.println("4");
    }

    System.out.println("5");
    return true;
  }
}
