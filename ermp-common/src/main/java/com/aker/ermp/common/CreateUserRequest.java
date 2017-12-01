package com.aker.ermp.common;

public class CreateUserRequest {
	private String userCode;
	private String userName;
	private String password;
	private String email;
	
	public CreateUserRequest() {
		
	}
	
	public CreateUserRequest(String userCode, String userName, String password, String email) {
		this.userCode = userCode;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
