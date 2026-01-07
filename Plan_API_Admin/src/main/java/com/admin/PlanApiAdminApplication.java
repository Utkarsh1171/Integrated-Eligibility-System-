package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.admin.Repository")
@ComponentScan(basePackages = "com.admin")
@EntityScan(basePackages = "com.admin.Entity")
public class PlanApiAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanApiAdminApplication.class, args);
    }
}
