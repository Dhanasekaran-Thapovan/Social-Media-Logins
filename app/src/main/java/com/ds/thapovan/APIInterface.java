package com.ds.thapovan;

import com.ds.thapovan.api.apiutils.APIUtil;
import com.ds.thapovan.api.response.GetEmployeeListResponse;
import com.ds.thapovan.expandable_response.ExpandableApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET(APIUtil.EXPANDABLE_LIST_ENDPOINT)
    Call<ExpandableApiResponse> getExpandableList(@Query("platform") String text);

}
