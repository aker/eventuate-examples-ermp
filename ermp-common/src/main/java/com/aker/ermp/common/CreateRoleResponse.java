package com.aker.ermp.common;

public class CreateRoleResponse {
	private String roleId;

	public CreateRoleResponse() {
		
	}
	
	public CreateRoleResponse(String roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
