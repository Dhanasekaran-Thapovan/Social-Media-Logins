package com.ds.thapovan.adduser_respose;

import com.google.gson.annotations.SerializedName;

public class AddUserRespose{

	@SerializedName("data")
	private Datas datas;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public Datas getDatas(){
		return datas;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}