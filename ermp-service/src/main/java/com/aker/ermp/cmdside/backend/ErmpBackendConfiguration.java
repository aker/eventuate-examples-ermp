package com.aker.ermp.cmdside.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aker.ermp.cmdside.backend.command.RoleCommand;
import com.aker.ermp.cmdside.backend.domain.RoleAggregate;
import com.aker.ermp.cmdside.backend.domain.RoleService;
import com.aker.ermp.cmdside.backend.domain.RoleServiceImpl;

import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStore;
import io.eventuate.javaclient.spring.EnableEventHandlers;

@Configuration
@EnableEventHandlers
public class ErmpBackendConfiguration {
	
	@Bean
	public AggregateRepository<RoleAggregate, RoleCommand> aggregateRepository(EventuateAggregateStore eventStore) {
		return new AggregateRepository<>(RoleAggregate.class, eventStore);
	}
	
	@Bean
	public RoleService roleService(AggregateRepository<RoleAggregate, RoleCommand> aggregateRepository) {
		return new RoleServiceImpl(aggregateRepository);
	}
}