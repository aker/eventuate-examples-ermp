package com.aker.ermp.common.event;

import com.aker.ermp.model.RoleInfo;

public class RoleCreatedEvent implements RoleEvent {
	
	RoleInfo role;
	
	private RoleCreatedEvent() {
		
	}
	
	public RoleCreatedEvent(RoleInfo role) {
		this.role = role;
	}
	
	public RoleInfo getRole() {
		return this.role;
	}
	
	public void setRole(RoleInfo role) {
		this.role = role;
	}

}
