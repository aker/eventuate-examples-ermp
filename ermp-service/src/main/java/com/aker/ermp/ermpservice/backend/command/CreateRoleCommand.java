package com.aker.ermp.ermpservice.backend.command;

import com.aker.ermp.model.RoleInfo;

public class CreateRoleCommand implements RoleCommand {
	
	private RoleInfo roleInfo;
	
	public CreateRoleCommand(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

}
