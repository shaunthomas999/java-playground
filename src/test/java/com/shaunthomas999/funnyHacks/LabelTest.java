package com.shaunthomas999.funnyHacks;

import org.junit.Test;

public class LabelTest {

  @Test
  public void labelTest() {

    System.out.println("Labels are allowed in Java");

    http://www.google.com
    https://www.google.com

    System.out.println("This is the end");
  }

  @Test
  public void labelledBreak() {
    System.out.println("...a");

    Task: // This should be before a loop and no lines in b/w
    for(int i=0; i<10; i++){
      if (i==8){
        break Task;
      }
      System.out.println("......."+i );
    }

    System.out.println("...b");
  }
}
