package com.shaunthomas999.designPatterns.singleton;

/**
 * Created by shaunthomas on 20/03/17.
 */
public class TestSingleton {

    public static void main(String args[]) {
        Customer customer = Customer.getCustomer();
        System.out.println(">>> " + customer.simpleResponse());
    }
}
