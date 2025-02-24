package com.shaunthomas999.designPatterns.businessDelegate;

/**
 * Created by shaunthomas on 01/04/17.
 */
public class Client {

    public static void main(String args[]) {

        BusinessLookup businessLookup = new BusinessLookup();
        businessLookup.setBusinessService(ServiceType.EJB);
        businessLookup.setBusinessService(ServiceType.JMS);

        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setBusinessLookup(businessLookup);

        businessDelegate.setServiceType(ServiceType.EJB);
        businessDelegate.doTask();

        businessDelegate.setServiceType(ServiceType.JMS);
        businessDelegate.doTask();
    }
}
