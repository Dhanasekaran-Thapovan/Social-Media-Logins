package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class CourtsItem{

	@SerializedName("courtName")
	private String courtName;

	@SerializedName("courtCode")
	private String courtCode;

	public String getCourtName(){
		return courtName;
	}

	public String getCourtCode(){
		return courtCode;
	}
}