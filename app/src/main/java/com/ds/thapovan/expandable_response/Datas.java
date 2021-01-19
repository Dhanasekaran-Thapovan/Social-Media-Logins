package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class Datas{

	@SerializedName("appVersion")
	private AppVersion appVersion;

	@SerializedName("recoveryOptions")
	private RecoveryOptions recoveryOptions;

	@SerializedName("message")
	private String message;

	public AppVersion getAppVersion(){
		return appVersion;
	}

	public RecoveryOptions getRecoveryOptions(){
		return recoveryOptions;
	}

	public String getMessage(){
		return message;
	}
}