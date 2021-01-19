package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class AppVersion{

	@SerializedName("app")
	private String app;

	@SerializedName("versionCodeMin")
	private String versionCodeMin;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("notes")
	private String notes;

	@SerializedName("upgradeUrl")
	private String upgradeUrl;

	@SerializedName("forceUpgrade")
	private String forceUpgrade;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("versionName")
	private String versionName;

	@SerializedName("platform")
	private String platform;

	@SerializedName("versionCode")
	private String versionCode;

	@SerializedName("updatedAt")
	private String updatedAt;

	public String getApp(){
		return app;
	}

	public String getVersionCodeMin(){
		return versionCodeMin;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getNotes(){
		return notes;
	}

	public String getUpgradeUrl(){
		return upgradeUrl;
	}

	public String getForceUpgrade(){
		return forceUpgrade;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getVersionName(){
		return versionName;
	}

	public String getPlatform(){
		return platform;
	}

	public String getVersionCode(){
		return versionCode;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}