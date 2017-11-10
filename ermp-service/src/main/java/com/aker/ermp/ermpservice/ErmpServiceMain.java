package com.aker.ermp.ermpservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.aker.ermp.commonswagger.CommonSwaggerConfiguration;
import com.aker.ermp.ermpservice.web.ErmpWebConfiguration;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;

@Import({ErmpWebConfiguration.class, EventuateDriverConfiguration.class, CommonSwaggerConfiguration.class})
@SpringBootApplication
public class ErmpServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(ErmpServiceMain.class, args);
    }

}
