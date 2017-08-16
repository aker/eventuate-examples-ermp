package com.aker.ermp.backend;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aker.ermp.backend.command.RoleCommand;
import com.aker.ermp.backend.domain.RoleAggregate;
import com.aker.ermp.backend.domain.RoleService;
import com.aker.ermp.web.ErmpWebConfiguration;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.spring.EnableEventHandlers;

@Configuration
@Import({ErmpWebConfiguration.class})
@EnableAutoConfiguration
@ComponentScan({"com.aker.ermp.backend",
                "com.aker.ermp.common"})
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
	
	@Bean
	public RoleQueryService queryService(RoleRepository repository) {
		return new RoleQueryService(repository);
	}
	
	@Bean
	public RoleQueryWorkflow roleQueryWorkflow(RoleQueryService queryService) {
		return new RoleQueryWorkflow(queryService);
	}
}