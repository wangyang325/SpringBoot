package com.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.springcloud.provider.controller")
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringcloudProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8001Application.class, args);
    }

}
