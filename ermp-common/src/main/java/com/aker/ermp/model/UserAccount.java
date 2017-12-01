package com.aker.ermp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount {

    @Id
    private String userId;
    
    @Column
    private String userCode;
    
    @Column
    private String userName;
    
    @Column
    private String password;

	@Column
    private String email;
    
    @Column
    private Boolean deleted;

    public UserAccount() {
    }

    public UserAccount(String userName) {
        this.userName = userName;
    }

    public UserAccount(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    
    public UserAccount(String userId, String userCode, String userName, String password, String email) {
    	this.userId = userId;
    	this.userCode = userCode;
    	this.userName = userName;
    	this.password = password;
    	this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
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

    public UserAccount merge(UserAccount newTodo) {
        return new UserAccount(userId,
                nonNull(newTodo.userName, userName));
    }

    private <T> T nonNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + userId +
                ", name='" + userName +
                '}';
    }
}