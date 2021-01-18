package com.ds.thapovan.api.response;

import java.util.List;

import com.ds.thapovan.api_respose.DataItem;
import com.google.gson.annotations.SerializedName;

public class GetEmployeeListResponse extends GenericResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private String status;

	public List<DataItem> getData(){
		return data;
	}

	public String getStatus(){
		return status;
	}
}