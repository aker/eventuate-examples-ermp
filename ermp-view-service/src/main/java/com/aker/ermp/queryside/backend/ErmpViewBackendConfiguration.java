package com.aker.ermp.queryside.backend;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aker.ermp.RoleRepository;
import com.aker.ermp.queryside.backend.domain.ErmpViewWorkflow;
import com.aker.ermp.queryside.backend.domain.RoleViewServiceImpl;

import io.eventuate.javaclient.spring.EnableEventHandlers;

@Configuration
@EnableEventHandlers
@EntityScan("com.aker.ermp")
@EnableJpaRepositories("com.aker.ermp")
public class ErmpViewBackendConfiguration {
	
	@Bean
	public ErmpViewWorkflow ermpViewEventSubscriber(RoleViewServiceImpl roleViewService) {
		return new ErmpViewWorkflow(roleViewService);
	}
	
	@Bean
	public RoleViewServiceImpl roleViewService(RoleRepository repository) {
		return new RoleViewServiceImpl(repository);
	}
}