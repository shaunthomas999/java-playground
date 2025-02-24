package com.shaunthomas999.profiling.profile01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


public class Class01ClassVariable {
  public List<Integer> list = new ArrayList<>();

  public void populateList() {
    Logger.getGlobal().info("Debug Point 2");

    for (int i = 0; i < 10000000; i++) {
      list.add(new Random().nextInt());
    }
    Logger.getGlobal().info("Debug Point 3");
  }
  public static void main(String[] args) {
    Logger.getGlobal().info("Debug Point 1");
    new Class01ClassVariable().populateList();
    Logger.getGlobal().info("Debug Point 4");
    try {
      System.gc();
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
