package com.ds.thapovan.expandable_response;

import com.google.gson.annotations.SerializedName;

public class RelationshipManagersItem{

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("extension")
	private String extension;

	@SerializedName("assignedProposals")
	private String assignedProposals;

	@SerializedName("assignedCustomers")
	private String assignedCustomers;

	@SerializedName("userRoleStr")
	private String userRoleStr;

	@SerializedName("gender")
	private String gender;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("employeeId")
	private String employeeId;

	@SerializedName("userId")
	private String userId;

	@SerializedName("branch")
	private String branch;

	@SerializedName("assignedApplications")
	private String assignedApplications;

	@SerializedName("assignedTermSheets")
	private String assignedTermSheets;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("userRoles")
	private String userRoles;

	@SerializedName("phone")
	private String phone;

	@SerializedName("assignedLeads")
	private String assignedLeads;

	@SerializedName("assignedDeals")
	private String assignedDeals;

	@SerializedName("middleName")
	private String middleName;

	@SerializedName("designation")
	private String designation;

	@SerializedName("department")
	private String department;

	@SerializedName("status")
	private int status;

	public String getLastName(){
		return lastName;
	}

	public String getExtension(){
		return extension;
	}

	public String getAssignedProposals(){
		return assignedProposals;
	}

	public String getAssignedCustomers(){
		return assignedCustomers;
	}

	public String getUserRoleStr(){
		return userRoleStr;
	}

	public String getGender(){
		return gender;
	}

	public String getMobile(){
		return mobile;
	}

	public String getEmployeeId(){
		return employeeId;
	}

	public String getUserId(){
		return userId;
	}

	public String getBranch(){
		return branch;
	}

	public String getAssignedApplications(){
		return assignedApplications;
	}

	public String getAssignedTermSheets(){
		return assignedTermSheets;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getUserRoles(){
		return userRoles;
	}

	public String getPhone(){
		return phone;
	}

	public String getAssignedLeads(){
		return assignedLeads;
	}

	public String getAssignedDeals(){
		return assignedDeals;
	}

	public String getMiddleName(){
		return middleName;
	}

	public String getDesignation(){
		return designation;
	}

	public String getDepartment(){
		return department;
	}

	public int getStatus(){
		return status;
	}
}