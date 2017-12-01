package com.aker.ermp.cmdside.backend.command;

public class CreateUserCommand implements UserCommand {
	
	private String userId;
	private String userCode;
	private String userName;
	private String password;
	private String email;
	
	public CreateUserCommand(String userCode, String userName, String password, String email) {
		this.userCode = userCode;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public CreateUserCommand(String userId, String userCode, String userName, String password, String email) {
		this.userCode = userCode;
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