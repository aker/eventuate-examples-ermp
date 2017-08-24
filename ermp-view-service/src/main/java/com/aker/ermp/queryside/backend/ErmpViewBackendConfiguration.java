package com.aker.ermp.queryside.backend;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.aker.ermp.RoleRepository;
import com.aker.ermp.queryside.backend.domain.ErmpViewEventSubscriber;
import com.aker.ermp.queryside.backend.domain.RoleViewServiceImpl;

import io.eventuate.javaclient.spring.EnableEventHandlers;

@Configuration
@EntityScan("com.aker.ermp")
@EnableJpaRepositories("com.aker.ermp")
@EnableEventHandlers
public class ErmpViewBackendConfiguration {
	
	@Bean
	public ErmpViewEventSubscriber ermpViewEventSubscriber(RoleViewServiceImpl roleViewService) {
		return new ErmpViewEventSubscriber(roleViewService);
	}
	
	@Bean
	public RoleViewServiceImpl roleViewService(RoleRepository repository) {
		return new RoleViewServiceImpl(repository);
	}
	
	@Bean
    public HttpMessageConverters customConverters() {
        HttpMessageConverter<?> additional = new MappingJackson2HttpMessageConverter();
        return new HttpMessageConverters(additional);
    }
}