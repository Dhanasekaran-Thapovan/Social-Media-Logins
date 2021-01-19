package com.ds.thapovan.expandable_response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LevelsItem implements Parcelable {

	@SerializedName("levelCode")
	private String levelCode;

	@SerializedName("caseStageId")
	private int caseStageId;

	@SerializedName("levelId")
	private int levelId;

	@SerializedName("levelName")
	private String levelName;

	@SerializedName("status")
	private List<StatusItem> status;

	protected LevelsItem(Parcel in) {
		levelCode = in.readString();
		caseStageId = in.readInt();
		levelId = in.readInt();
		levelName = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(levelCode);
		dest.writeInt(caseStageId);
		dest.writeInt(levelId);
		dest.writeString(levelName);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<LevelsItem> CREATOR = new Creator<LevelsItem>() {
		@Override
		public LevelsItem createFromParcel(Parcel in) {
			return new LevelsItem(in);
		}

		@Override
		public LevelsItem[] newArray(int size) {
			return new LevelsItem[size];
		}
	};

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

	public List<StatusItem> getStatus(){
		return status;
	}
}