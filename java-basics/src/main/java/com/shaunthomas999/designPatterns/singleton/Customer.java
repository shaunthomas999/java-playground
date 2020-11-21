package com.shaunthomas999.designPatterns.singleton;

/**
 * Created by shaunthomas on 20/03/17.
 */
public class Customer {

    private static Customer customer;

    // Make this private to present creation of objects of this class
    private Customer() {}

    public static synchronized Customer getCustomer() {
        if(customer == null) {
            customer = new Customer();
        }
        return customer;
    }

    public String simpleResponse() {
        return "This is a simple response";
    }
}
