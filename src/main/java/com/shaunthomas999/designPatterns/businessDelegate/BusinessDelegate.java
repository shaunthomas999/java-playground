package com.shaunthomas999.designPatterns.businessDelegate;

/**
 * Created by shaunthomas on 01/04/17.
 */
public class BusinessDelegate {

    private BusinessLookup businessLookup;

    private ServiceType serviceType;

    private BusinessService businessService;

    public void setBusinessLookup(BusinessLookup businessLookup) {
        this.businessLookup = businessLookup;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        businessService = businessLookup.getBusinessService(serviceType);
        businessService.doProcessing();

    }
}
