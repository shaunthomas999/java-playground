package com.shaunthomas999.java21;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class A_VirtualThreadsExamples {

  /**
   * Below code is not working!!
   */
  public void example_01() {
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      // 10_000
      IntStream.range(0, 25).forEach(i -> {
        executor.submit(() -> {
          System.out.println("virtual-thread: start~" + i);
          Thread.sleep(Duration.ofMillis(100));
          System.out.println("virtual-thread: end~" + i);
          return i;
        });
      });
    }  // executor.close() is called implicitly, and waits
  }
}
