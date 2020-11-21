package com.shaunthomas999.advanced.concurrency;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * See https://www.baeldung.com/java-delay-code-execution
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ThreadInterruptSample {

  public static boolean execute() {
    log.info("1");

    try {
      TimeUnit.SECONDS.sleep(10);
      log.info("2");
    } catch (InterruptedException ie) {
      log.info("3");
      Thread.currentThread().interrupt();
      log.info("4");
    }

    log.info("5");
    return true;
  }
}
