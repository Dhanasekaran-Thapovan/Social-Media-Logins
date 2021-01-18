package com.ds.thapovan;

import com.ds.thapovan.api.apiutils.APIUtil;
import com.ds.thapovan.api.response.GetEmployeeListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET(APIUtil.EMPLOYLEE_LIST_URL)
    Call<GetEmployeeListResponse> getEmployees();

}
