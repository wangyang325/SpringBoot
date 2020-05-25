package wangyang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@EnableAutoConfiguration(exclude = RedisAutoConfiguration.class)
@Controller
//@ConfigurationProperties(prefix = "Config")
public class IndexController {

//    @Bean
//    public  StringHttpMessageConverter setMessage () {
//        StringHttpMessageConverter convert = new StringHttpMessageConverter(Charset.forName("ISO8859-1"));
//        return convert;
//    }

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
    public List test() {
        Logger.getGlobal().warning("This is test msg for warning");
        List<String> lst= new ArrayList<String>();
        lst.add("1");
        lst.add("2");
        lst.add("3");
        lst.add("你好");

        return lst;
    }

    @RequestMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("name", "wangyanng");
        return "index";
    }
}
