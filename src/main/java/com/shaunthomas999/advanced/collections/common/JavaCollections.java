package com.shaunthomas999.advanced.collections.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class JavaCollections {

  public static void main(String[] args) {

    var intList = Arrays.asList(1, 2, 3, 4, 5);

    Collections.sort(intList);

    HashMap<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.get("key1");

    System.out.println("intList: " + intList);
    System.out.println("map: " + map);
  }
}
