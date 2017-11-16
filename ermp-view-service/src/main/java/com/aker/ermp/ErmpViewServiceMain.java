package com.aker.ermp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.aker.ermp.commonswagger.CommonSwaggerConfiguration;
import com.aker.ermp.ermpservice.web.ErmpWebConfiguration;
import com.aker.ermp.queryside.web.ErmpViewWebConfiguration;

@Import({ErmpWebConfiguration.class, ErmpViewWebConfiguration.class, EventuateLocalErmpConfiguration.class, CommonSwaggerConfiguration.class})
@SpringBootApplication
public class ErmpViewServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(ErmpViewServiceMain.class, args);
    }

}
