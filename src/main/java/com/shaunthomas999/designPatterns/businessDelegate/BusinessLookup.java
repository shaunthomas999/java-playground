package com.shaunthomas999.designPatterns.businessDelegate;

/**
 * Created by shaunthomas on 01/04/17.
 */
public class BusinessLookup {

    private EJBservice ejBservice;

    private JMSservice jmSservice;

    public void setBusinessService(ServiceType serviceType) {
        if(serviceType.equals(ServiceType.EJB)) {
            ejBservice = new EJBservice();
        }
        else {
            jmSservice = new JMSservice();
        }
    }

    public BusinessService getBusinessService(ServiceType serviceType) {
        if(serviceType.equals(ServiceType.EJB)) {
            return ejBservice;
        }
        else {
            return jmSservice;
        }
    }

}
