package com.aker.ermp.queryside.web;

import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.aker.ermp.queryside.backend.ErmpViewBackendConfiguration;

@Configuration
@Import({ErmpViewBackendConfiguration.class})
@ComponentScan({"com.aker.ermp.common",
				"com.aker.ermp.queryside.web"})
public class ErmpViewWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ServletListenerRegistrationBean<RequestContextListener> httpRequestContextListener() {
		return new ServletListenerRegistrationBean<RequestContextListener>(new RequestContextListener());
	}
}
