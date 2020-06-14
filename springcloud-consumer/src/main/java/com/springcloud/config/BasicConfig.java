package com.springcloud.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BasicConfig {

    @Bean
    @LoadBalanced  // Ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule() {
//        // RoundRobinRule
//        // RandomRule
//        // AvailabilityFilteringRule : filter the bad services than round Robbin
//        // WeightedResponseTimeRule
//        // BestAvailableRule : filter the bad services than choose the low concurrency
//        // ZoneAvoidanceRule
//        return new RandomRule();
//    }
}
