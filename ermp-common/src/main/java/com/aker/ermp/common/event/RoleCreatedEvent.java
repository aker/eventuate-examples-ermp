package com.aker.ermp.common.event;

import com.aker.ermp.model.RoleInfo;

public class RoleCreatedEvent implements RoleEvent {
	
	RoleInfo roleInfo;
	
	private RoleCreatedEvent() {
		
	}
	
	public RoleCreatedEvent(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	
	public RoleInfo getRoleInfo() {
		return this.roleInfo;
	}
	
	public void setRoleInfo(RoleInfo role) {
		this.roleInfo = role;
	}

}
