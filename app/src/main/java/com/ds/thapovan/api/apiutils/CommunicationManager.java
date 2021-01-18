package com.ds.thapovan.api.apiutils;

import com.ds.thapovan.api.masterapi.MasterAPI;
import com.ds.thapovan.api.subscriber.MasterEventSubscriber;

public class CommunicationManager {
    private static CommunicationManager sInstance = getInstance();
    private CommunicationManager() {
    }
    public static CommunicationManager getInstance() {
        if (sInstance == null) {
            synchronized (CommunicationManager.class) {
                sInstance = new CommunicationManager();
            }
        }
        return sInstance;
    }

    public void getEmployeeDetails(MasterEventSubscriber subscriber) {
        MasterAPI.getEmployeeDetails(subscriber);
    }
}
