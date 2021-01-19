package com.ds.thapovan.expandable_response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Json{

	@SerializedName("version")
	private String version;

	@SerializedName("npaCategories")
	private List<NpaCategoriesItem> npaCategories;

	public String getVersion(){
		return version;
	}

	public List<NpaCategoriesItem> getNpaCategories(){
		return npaCategories;
	}
}