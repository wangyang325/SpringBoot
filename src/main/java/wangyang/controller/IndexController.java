package wangyang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@EnableAutoConfiguration(exclude = RedisAutoConfiguration.class)
@Controller
//@ConfigurationProperties(prefix = "Config")
public class IndexController {

    @Value("${IMAGE_SERVER}")
    private String iser;
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    //@Value("${IMAGE_SERVER}")
    private String test ;

    @RequestMapping("/")
    @ResponseBody
    public String test() {
        Logger.getGlobal().warning("This is test msg for warning");
        return "1";
    }
}
