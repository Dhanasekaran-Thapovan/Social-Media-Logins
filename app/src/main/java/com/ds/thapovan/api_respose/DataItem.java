package com.ds.thapovan.api_respose;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("profile_image")
	private String profileImage;

	@SerializedName("employee_name")
	private String employeeName;

	@SerializedName("employee_salary")
	private String employeeSalary;

	@SerializedName("id")
	private String id;

	@SerializedName("employee_age")
	private String employeeAge;

	public String getProfileImage(){
		return profileImage;
	}

	public String getEmployeeName(){
		return employeeName;
	}

	public String getEmployeeSalary(){
		return employeeSalary;
	}

	public String getId(){
		return id;
	}

	public String getEmployeeAge(){
		return employeeAge;
	}
}