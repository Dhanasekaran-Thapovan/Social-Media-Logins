package com.ds.thapovan;

import com.ds.thapovan.adduser_respose.AddUserRespose;
import com.ds.thapovan.api_respose.GetEmployeeListResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @GET(APIConstants.EMPLOYLEE_LIST_URL)
    Call<GetEmployeeListResponse> getEmployees();

    @POST(APIConstants.ADD_EMPLOYEE)
    Call<AddUserRespose> postUser(@Body HashMap<String,String> map);

}
