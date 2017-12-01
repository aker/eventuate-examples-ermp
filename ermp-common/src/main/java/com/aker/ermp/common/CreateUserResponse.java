package com.aker.ermp.common;

public class CreateUserResponse {
	private String userId;

	public CreateUserResponse() {
		
	}
	
	public CreateUserResponse(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}