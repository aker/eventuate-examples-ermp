package com.aker.ermp.queryside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.aker.ermp.commonswagger.CommonSwaggerConfiguration;
import com.aker.ermp.queryside.web.ErmpViewWebConfiguration;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;

@Import({ErmpViewWebConfiguration.class, EventuateDriverConfiguration.class, CommonSwaggerConfiguration.class})
@SpringBootApplication
public class ErmpViewServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(ErmpViewServiceMain.class, args);
    }

}
