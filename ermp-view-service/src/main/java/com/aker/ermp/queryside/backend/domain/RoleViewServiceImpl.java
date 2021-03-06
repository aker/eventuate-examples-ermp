package com.aker.ermp.queryside.backend.domain;

import java.util.List;

import com.aker.ermp.RoleRepository;
import com.aker.ermp.model.Role;

public class RoleViewServiceImpl {
	
	private RoleRepository repository;
	
	public RoleViewServiceImpl(RoleRepository repository) {
		this.repository = repository;
	}
	
	public Role save(Role role) {
		return repository.save(role);
	}
	
	public List<Role> getAll() {
		return repository.findAll();
	}
	
    public Role findById(String roleId) {
    	Role res = repository.findOne(roleId);
    	
    	return res;
    }
}