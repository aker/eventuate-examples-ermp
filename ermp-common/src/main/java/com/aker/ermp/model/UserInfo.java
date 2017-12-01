package com.aker.ermp.model;

public class UserInfo {
	private String userId;
	private String userCode;
	private String userName;
	private String password;
	private String email;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String userId, String userCode, String userName, String password, String email) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
