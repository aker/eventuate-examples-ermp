package com.aker.ermp.ermpservice.backend;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aker.ermp.ermpservice.backend.command.RoleCommand;
import com.aker.ermp.ermpservice.backend.domain.RoleAggregate;
import com.aker.ermp.ermpservice.backend.domain.RoleService;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.spring.EnableEventHandlers;

@Configuration
@EntityScan("com.aker.ermp")
@EnableJpaRepositories("com.aker.ermp")
@EnableEventHandlers
public class ErmpBackendConfiguration {
	
	@Bean
	public AggregateRepository<RoleAggregate, RoleCommand> aggregateRepository(EventuateAggregateStore eventStore) {
		return new AggregateRepository<>(RoleAggregate.class, eventStore);
	}
	
	@Bean
	public RoleService updateService(AggregateRepository<RoleAggregate, RoleCommand> aggregateRepository) {
		return new RoleService(aggregateRepository);
	}
}