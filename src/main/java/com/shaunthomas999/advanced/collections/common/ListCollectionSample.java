package com.shaunthomas999.advanced.collections.common;

import java.util.Arrays;
import java.util.Collections;

public class ListCollectionSample {

  public static void main(String[] args) {

    var intList = Arrays.asList(4, 2, 1, 4, 5);
    Collections.sort(intList);
    System.out.println("intList: " + intList);
  }
}
