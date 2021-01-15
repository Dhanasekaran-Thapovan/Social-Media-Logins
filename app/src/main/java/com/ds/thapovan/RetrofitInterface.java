package com.ds.thapovan;

import com.ds.thapovan.api_respose.GetEmployeeListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET(APIConstants.EMPLOYLEE_LIST_URL)
    Call<GetEmployeeListResponse> getEmployees();

}
