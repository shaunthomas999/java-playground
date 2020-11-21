package com.shaunthomas999.designPatterns.businessDelegate;

/**
 * Created by shaunthomas on 01/04/17.
 */
public class JMSservice implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("JMS in service");
    }
}
