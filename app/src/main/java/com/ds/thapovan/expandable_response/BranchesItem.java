package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class BranchesItem{

	@SerializedName("code")
	private String code;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	public String getCode(){
		return code;
	}

	public String getDescription(){
		return description;
	}

	public String getId(){
		return id;
	}
}