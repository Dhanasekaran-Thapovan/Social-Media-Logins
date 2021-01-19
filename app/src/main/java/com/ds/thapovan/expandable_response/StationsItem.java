package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class StationsItem{

	@SerializedName("stationCode")
	private String stationCode;

	@SerializedName("stationName")
	private String stationName;

	public String getStationCode(){
		return stationCode;
	}

	public String getStationName(){
		return stationName;
	}
}