package com.Citizen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan(basePackages = {
        "com.Citizen.Entity",
        "com.admin.Entity"
})
public class CitizenApiArApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitizenApiArApplication.class, args);
    }
}
