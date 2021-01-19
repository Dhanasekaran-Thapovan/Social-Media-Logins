package com.ds.thapovan.api.apiutils;

import androidx.annotation.NonNull;

import com.ds.thapovan.api.response.GenericResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ds.thapovan.api.apiutils.APIUtil.getGenericResponseErr;
import static com.ds.thapovan.api.apiutils.APIUtil.processUnSuccessResponce;


public abstract class APICallback<T extends GenericResponse> implements Callback<T> {

    private Class<T> className;

    public APICallback(Class<T> className){
        this.className = className;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if(response.isSuccessful()) {
            onAPIResponse(response.body());
        } else {
            onAPIResponse(processUnSuccessResponce(response.code(), response.errorBody(), className));
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        onAPIResponse(getGenericResponseErr(className));
    }

    public abstract void onAPIResponse(T response);
}
