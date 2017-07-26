package com.aker.ermp.backend.domain;

import java.util.concurrent.CompletableFuture;

import com.aker.ermp.backend.command.CreateRoleCommand;
import com.aker.ermp.backend.command.RoleCommand;
import com.aker.ermp.model.RoleInfo;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;

public class RoleService {
	
	private final AggregateRepository<RoleAggregate, RoleCommand> aggregateRepository;
	
	public RoleService(AggregateRepository<RoleAggregate, RoleCommand> roleRepository) {
		this.aggregateRepository = roleRepository;
	}
	
	public CompletableFuture<EntityWithIdAndVersion<RoleAggregate>> save(RoleInfo role) {
		return aggregateRepository.save(new CreateRoleCommand(role));
	}
}