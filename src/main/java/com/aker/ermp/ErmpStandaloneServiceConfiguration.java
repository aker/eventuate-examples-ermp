package com.aker.ermp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.aker.ermp.backend.ErmpBackendConfiguration;
import com.aker.ermp.commonswagger.CommonSwaggerConfiguration;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;

@SpringBootApplication
@Import({ErmpBackendConfiguration.class, EventuateDriverConfiguration.class, CommonSwaggerConfiguration.class})
public class ErmpStandaloneServiceConfiguration {

}
