package com.springcloud.zuul.config;

import com.springcloud.zuul.filter.CustomizedFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CustomizedFilter customizedFilter() {
        return new CustomizedFilter();
    }
}
