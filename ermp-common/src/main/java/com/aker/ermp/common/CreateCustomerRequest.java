package com.aker.ermp.common;

public class CreateCustomerRequest {
	private String ssn;
	private String password;
	private String email;
	
	public CreateCustomerRequest() {
		
	}
	
	public CreateCustomerRequest(String ssn, String password, String email) {
		this.ssn = ssn;
		this.password = password;
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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
