package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class DebitCollectorsItem{

	@SerializedName("assignedCutomers")
	private String assignedCutomers;

	@SerializedName("dcName")
	private String dcName;

	@SerializedName("id")
	private String id;

	public String getAssignedCutomers(){
		return assignedCutomers;
	}

	public String getDcName(){
		return dcName;
	}

	public String getId(){
		return id;
	}
}