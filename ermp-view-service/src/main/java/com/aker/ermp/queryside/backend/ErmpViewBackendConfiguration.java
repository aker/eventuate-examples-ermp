package com.aker.ermp.queryside.backend;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aker.ermp.RoleRepository;

import io.eventuate.javaclient.spring.EnableEventHandlers;

@Configuration
@EntityScan("com.aker.ermp")
@EnableJpaRepositories("com.aker.ermp")
@EnableEventHandlers
public class ErmpViewBackendConfiguration {
	
	@Bean
	public ErmpViewEventSubscriber ermpViewEventSubscriber(RoleQueryService roleQueryService) {
		return new ErmpViewEventSubscriber(roleQueryService);
	}
	
	@Bean
	public RoleQueryService roleQueryService(RoleRepository repository) {
		return new RoleQueryService(repository);
	}
}