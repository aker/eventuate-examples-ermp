package com.aker.ermp.queryside.backend;

import com.aker.ermp.RoleRepository;
import com.aker.ermp.model.Role;

public class RoleQueryService {
	
	private RoleRepository repository;
	
	public RoleQueryService(RoleRepository repository) {
		this.repository = repository;
	}
	
	public Role save(Role role) {
		return repository.save(role);
	}
}
