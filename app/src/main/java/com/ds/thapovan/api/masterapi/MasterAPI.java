package com.ds.thapovan.api.masterapi;

import android.util.Log;

import androidx.annotation.NonNull;

import com.ds.thapovan.api.apiutils.APIAbstract;
import com.ds.thapovan.api.apiutils.APICallback;
import com.ds.thapovan.api.subscriber.ExpandableEventSubscriber;
import com.ds.thapovan.expandable_response.ExpandableApiResponse;
import com.google.gson.Gson;

import retrofit2.Call;

public class MasterAPI extends APIAbstract {

   public static void getExpandableDetails(final ExpandableEventSubscriber subscriber){
        masterApiInterface.getExpandableList("ANDROID").enqueue(new APICallback<ExpandableApiResponse>(ExpandableApiResponse.class) {
            @Override
            public void onAPIResponse(ExpandableApiResponse response) {
                subscriber.onExpandableResponse(response);
                Gson gson = new Gson();
                Log.d("Response",gson.toJson(response));

            }

            @Override
            public void onFailure(@NonNull Call<ExpandableApiResponse> call, @NonNull Throwable t) {
                Log.e("error",t.getMessage());
            }
        });
   }
}
