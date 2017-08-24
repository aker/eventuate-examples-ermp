package com.aker.ermp.queryside.backend.domain;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.persistence.EntityNotFoundException;

import com.aker.ermp.RoleRepository;
import com.aker.ermp.model.Role;

import io.eventuate.CompletableFutureUtil;

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
	
    public CompletableFuture<Role> findById(String roleId) {
    	Role res = repository.findOne(roleId);
        if (res != null) {
            return CompletableFuture.completedFuture(res);
        }
        return CompletableFutureUtil.failedFuture(new EntityNotFoundException("No role found for given id"));
    }
}
