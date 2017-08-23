package com.aker.ermp.ermpservice.web;

import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.aker.ermp.ermpservice.backend.ErmpBackendConfiguration;

@Configuration
@Import({ErmpBackendConfiguration.class})
@ComponentScan({"com.aker.ermp.common",
				"com.aker.ermp.ermpservice.web"})
public class ErmpWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ServletListenerRegistrationBean<RequestContextListener> httpRequestContextListener() {
		return new ServletListenerRegistrationBean<RequestContextListener>(new RequestContextListener());
	}
}
