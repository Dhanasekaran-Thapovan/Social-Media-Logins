package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class WorkflowRulesItem{

	@SerializedName("json")
	private Json json;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	public Json getJson(){
		return json;
	}

	public String getId(){
		return id;
	}

	public String getType(){
		return type;
	}
}