package com.aker.ermp.backend;

public class RoleQueryService {
	
	private RoleRepository repository;
	
	public RoleQueryService(RoleRepository repository) {
		this.repository = repository;
	}
	
	public Role save(Role role) {
		return repository.save(role);
	}
}
