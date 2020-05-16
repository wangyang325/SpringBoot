package wangyang.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import wangyang.controller.IndexController;

@SpringBootApplication(scanBasePackages = "wangyang.controller")
//@ComponentScan("wangyang.controller")
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}
