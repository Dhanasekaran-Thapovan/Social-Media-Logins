package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class CaseStageLevelStatusItem{

	@SerializedName("statusDescription")
	private String statusDescription;

	@SerializedName("statusId")
	private int statusId;

	@SerializedName("caseLevelId")
	private int caseLevelId;

	@SerializedName("statusCode")
	private String statusCode;

	public String getStatusDescription(){
		return statusDescription;
	}

	public int getStatusId(){
		return statusId;
	}

	public int getCaseLevelId(){
		return caseLevelId;
	}

	public String getStatusCode(){
		return statusCode;
	}
}