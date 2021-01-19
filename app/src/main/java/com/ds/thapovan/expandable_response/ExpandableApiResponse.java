package com.ds.thapovan.expandable_response;

import com.ds.thapovan.api.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

public class ExpandableApiResponse extends GenericResponse  {


	@SerializedName("data")
	private Datas datas;

	public Datas getDatas(){
		return datas;
	}


}