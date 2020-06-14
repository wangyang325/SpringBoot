package wangyang.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication(scanBasePackages = "wangyang")
//@EnableScheduling
@EnableHystrix
public class HystrixApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(HystrixApplication.class, args);
    }
}
