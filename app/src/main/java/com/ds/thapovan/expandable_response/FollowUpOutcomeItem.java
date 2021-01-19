package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class FollowUpOutcomeItem{

	@SerializedName("typeName")
	private String typeName;

	@SerializedName("typeId")
	private int typeId;

	@SerializedName("typeCode")
	private int typeCode;

	public String getTypeName(){
		return typeName;
	}

	public int getTypeId(){
		return typeId;
	}

	public int getTypeCode(){
		return typeCode;
	}
}