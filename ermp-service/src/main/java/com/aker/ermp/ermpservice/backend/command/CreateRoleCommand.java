package com.aker.ermp.ermpservice.backend.command;

public class CreateRoleCommand implements RoleCommand {
	
	private String name;
	
	public CreateRoleCommand(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}