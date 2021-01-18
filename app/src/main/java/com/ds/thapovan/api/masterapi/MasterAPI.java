package com.ds.thapovan.api.masterapi;

import android.util.Log;

import com.ds.thapovan.api.apiutils.APIAbstract;
import com.ds.thapovan.api.apiutils.APICallback;
import com.ds.thapovan.api.response.GetEmployeeListResponse;
import com.ds.thapovan.api.subscriber.MasterEventSubscriber;
import com.google.gson.Gson;

public class MasterAPI extends APIAbstract {

    public static void getEmployeeDetails(final MasterEventSubscriber subscriber) {
        masterApiInterface.getEmployees().enqueue(new APICallback<GetEmployeeListResponse>(GetEmployeeListResponse.class) {
            @Override
            public void onAPIResponse(GetEmployeeListResponse response) {
                subscriber.onEmployeeResponse(response);
                Gson gson = new Gson();
                Log.d("Response",gson.toJson(response));
            }
        });
    }
}
