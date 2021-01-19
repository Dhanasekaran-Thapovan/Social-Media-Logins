package com.ds.thapovan.api.subscriber;

import com.ds.thapovan.api.response.GetEmployeeListResponse;

public interface MasterEventSubscriber {
    void onEmployeeResponse(GetEmployeeListResponse response);


}
