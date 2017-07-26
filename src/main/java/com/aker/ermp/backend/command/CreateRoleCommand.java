package com.aker.ermp.backend.command;

import com.aker.ermp.model.RoleInfo;

public class CreateRoleCommand implements RoleCommand {
	
	private RoleInfo role;
	
	public CreateRoleCommand(RoleInfo role) {
		this.role = role;
	}
	
	public RoleInfo getRole() {
		return role;
	}

}
