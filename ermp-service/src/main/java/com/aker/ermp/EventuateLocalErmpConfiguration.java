package com.aker.ermp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.eventuate.javaclient.spring.common.EventuateCommonConfiguration;
import io.eventuate.javaclient.spring.jdbc.EventuateJdbcAccess;
import io.eventuate.local.java.jdbckafkastore.EventuateLocalConfiguration;
import io.eventuate.local.java.jdbckafkastore.EventuateLocalJdbcAccess;
import io.eventuate.local.java.kafka.EventuateKafkaConfigurationProperties;

@Configuration
@EnableConfigurationProperties(EventuateKafkaConfigurationProperties.class)
@EnableTransactionManagement
@Import(EventuateCommonConfiguration.class)
public class EventuateLocalErmpConfiguration extends EventuateLocalConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties dataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
	    return dataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	@ConfigurationProperties("eventuateLocal.datasource")
	public DataSourceProperties eventuateDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("eventuateLocal.datasource")
	public DataSource eventuateDataSource() {
	    return eventuateDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	public EventuateJdbcAccess eventuateJdbcAccess(@Qualifier("eventuateDataSource") DataSource eventuateDataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(eventuateDataSource);
		return new EventuateLocalJdbcAccess(jdbcTemplate);
	}
}
