package wangyang.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HystrixController {

    @HystrixCommand(fallbackMethod = "fallback_hystrix", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "500"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "1"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000")
    })
    @RequestMapping(value = "/hystrix")
    @ResponseBody
    public String hystrix() throws InterruptedException {
        Thread.sleep(3000);
        return "Hystrix service";
    }

    private String fallback_hystrix() {
        return "Request fails. It takes long time to response";
    }
}
