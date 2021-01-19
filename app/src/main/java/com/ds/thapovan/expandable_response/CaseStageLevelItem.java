package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class CaseStageLevelItem{

	@SerializedName("levelCode")
	private String levelCode;

	@SerializedName("caseStageId")
	private int caseStageId;

	@SerializedName("levelId")
	private int levelId;

	@SerializedName("levelName")
	private String levelName;

	public String getLevelCode(){
		return levelCode;
	}

	public int getCaseStageId(){
		return caseStageId;
	}

	public int getLevelId(){
		return levelId;
	}

	public String getLevelName(){
		return levelName;
	}
}