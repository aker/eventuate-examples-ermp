package com.aker.ermp.cmdside.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aker.ermp.cmdside.backend.command.RoleCommand;
import com.aker.ermp.cmdside.backend.command.UserCommand;
import com.aker.ermp.cmdside.backend.domain.RoleAggregate;
import com.aker.ermp.cmdside.backend.domain.RoleService;
import com.aker.ermp.cmdside.backend.domain.RoleServiceImpl;
import com.aker.ermp.cmdside.backend.domain.UserAggregate;
import com.aker.ermp.cmdside.backend.domain.UserService;
import com.aker.ermp.cmdside.backend.domain.UserServiceImpl;

import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStore;

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
	
	@Bean
	public UserService userService(AggregateRepository<UserAggregate, UserCommand> aggregateRepository) {
		return new UserServiceImpl(aggregateRepository);
	}
}