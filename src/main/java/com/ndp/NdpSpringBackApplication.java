package com.ndp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class NdpSpringBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(NdpSpringBackApplication.class, args);
    }

}
