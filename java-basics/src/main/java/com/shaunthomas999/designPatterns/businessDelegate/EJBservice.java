package com.shaunthomas999.designPatterns.businessDelegate;

/**
 * Created by shaunthomas on 01/04/17.
 */
public class EJBservice implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("EJB in service");
    }
}
