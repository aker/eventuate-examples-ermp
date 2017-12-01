package com.aker.ermp.queryside.backend;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aker.ermp.RoleRepository;
import com.aker.ermp.UserRepository;
import com.aker.ermp.queryside.backend.domain.ErmpViewWorkflow;
import com.aker.ermp.queryside.backend.domain.RoleViewServiceImpl;
import com.aker.ermp.queryside.backend.domain.UserViewServiceImpl;

import io.eventuate.javaclient.spring.EnableEventHandlers;

@Configuration
@EnableEventHandlers
@EntityScan("com.aker.ermp")
@EnableJpaRepositories("com.aker.ermp")
public class ErmpViewBackendConfiguration {
	
	@Bean
	public ErmpViewWorkflow ermpViewEventSubscriber(UserViewServiceImpl userViewService, RoleViewServiceImpl roleViewService) {
		return new ErmpViewWorkflow(userViewService, roleViewService);
	}
	
	@Bean
	public RoleViewServiceImpl roleViewService(RoleRepository repository) {
		return new RoleViewServiceImpl(repository);
	}
	
	@Bean
	public UserViewServiceImpl userViewService(UserRepository repository) {
		return new UserViewServiceImpl(repository);
	}
}