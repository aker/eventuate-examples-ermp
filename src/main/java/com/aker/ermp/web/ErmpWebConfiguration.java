package com.aker.ermp.web;

import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({"com.aker.ermp.web"})
public class ErmpWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ServletListenerRegistrationBean<RequestContextListener> httpRequestContextListener() {
		return new ServletListenerRegistrationBean<RequestContextListener>(new RequestContextListener());
	}
}
