package com.shaunthomas999.java25;

public class ScopedValueExample {

  public void process() {
    ScopedValue<String> userId = ScopedValue.newInstance();

    ScopedValue.where(userId, "user123").run(() -> {
      // Inside this block, userId is bound to "user123"
      System.out.println("User ID: " + userId.get());

      // You can create nested scopes
      ScopedValue.where(userId, "user456").run(() -> {
        System.out.println("Nested User ID: " + userId.get());
      });

      // Back to the outer scope
      System.out.println("Back to User ID: " + userId.get());
    });

    userId.get(); // This will throw an exception since userId is not bound here
  }
}
