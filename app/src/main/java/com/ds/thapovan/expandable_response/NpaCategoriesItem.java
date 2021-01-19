package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class NpaCategoriesItem{

	@SerializedName("name")
	private String name;

	@SerializedName("fromDays")
	private int fromDays;

	@SerializedName("toDays")
	private int toDays;

	@SerializedName("abbreviation")
	private String abbreviation;

	@SerializedName("provision_in_percentage")
	private int provisionInPercentage;

	public String getName(){
		return name;
	}

	public int getFromDays(){
		return fromDays;
	}

	public int getToDays(){
		return toDays;
	}

	public String getAbbreviation(){
		return abbreviation;
	}

	public int getProvisionInPercentage(){
		return provisionInPercentage;
	}
}