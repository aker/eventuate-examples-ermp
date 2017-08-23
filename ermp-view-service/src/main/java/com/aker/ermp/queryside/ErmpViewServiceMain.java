package com.aker.ermp.queryside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.aker.ermp.commonswagger.CommonSwaggerConfiguration;
import com.aker.ermp.queryside.web.ErmpViewWebConfiguration;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;

@Configuration
@Import({ErmpViewWebConfiguration.class,
		EventuateDriverConfiguration.class,
		CommonSwaggerConfiguration.class})
@EnableAutoConfiguration
public class ErmpViewServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(ErmpViewServiceMain.class, args);
    }

}