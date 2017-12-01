package com.aker.ermp.common.event;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class UserCreatedEvent implements UserEvent {
	
	private String userId;
	private String userCode;
	private String userName;
	private String password;
	private String email;

	private UserCreatedEvent() {
	}
	
	public UserCreatedEvent(String userId, String userCode, String userName, String password, String email) {
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

	@Override
	public boolean equals(Object obj) {
	    return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this);
	}
}