package com.aker.ermp.ermpservice.backend.domain;

import com.aker.ermp.ermpservice.backend.command.CreateRoleCommand;
import com.aker.ermp.ermpservice.backend.command.RoleCommand;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.sync.AggregateRepository;

public class RoleServiceImpl implements RoleService {
	
	private final AggregateRepository<RoleAggregate, RoleCommand> aggregateRepository;
	
	public RoleServiceImpl(AggregateRepository<RoleAggregate, RoleCommand> roleRepository) {
		this.aggregateRepository = roleRepository;
	}
	
	@Override
	public EntityWithIdAndVersion<RoleAggregate> createRole(String name) {
		return aggregateRepository.save(new CreateRoleCommand(name));
	}
}