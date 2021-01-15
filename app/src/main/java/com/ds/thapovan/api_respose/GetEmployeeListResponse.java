package com.ds.thapovan.api_respose;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetEmployeeListResponse{

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