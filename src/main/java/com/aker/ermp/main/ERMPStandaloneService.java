package com.aker.ermp.main;

import com.aker.ermp.ErmpStandaloneServiceConfiguration;
import org.springframework.boot.SpringApplication;


public class ERMPStandaloneService {

    public static void main(String[] args) {
        SpringApplication.run(ErmpStandaloneServiceConfiguration.class, args);
    }

}