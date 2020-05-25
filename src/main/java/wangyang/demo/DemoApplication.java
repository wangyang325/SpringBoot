package wangyang.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import wangyang.controller.IndexController;

@SpringBootApplication(scanBasePackages = "wangyang")
//@ComponentScan("wangyang.controller")
//@EnableScheduling
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(DemoApplication.class);
        return super.configure(builder);
    }
}
