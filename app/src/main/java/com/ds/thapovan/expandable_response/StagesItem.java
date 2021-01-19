package com.ds.thapovan.expandable_response;

import android.os.Parcel;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

public class StagesItem  {

	@SerializedName("stageName")
	private String stageName;

	@SerializedName("stageCode")
	private String stageCode;

	@SerializedName("levels")
	private List<LevelsItem> levels;

	@SerializedName("stageId")
	private int stageId;

	public String getStageName(){
		return stageName;
	}

	public String getStageCode(){
		return stageCode;
	}

	public List<LevelsItem> getLevels(){
		return levels;
	}

	public int getStageId(){
		return stageId;
	}
}