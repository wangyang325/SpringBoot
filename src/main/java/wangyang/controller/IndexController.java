package wangyang.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wangyang.bean.User;

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

    @ResponseBody
    @RequestMapping("/doPost")
    public String[] doPost() {
        String[] rs = {"1", "2"};
        return rs;
    }

    @ResponseBody
    @RequestMapping("/doPostP")
    public String doPostByP(@RequestBody User pUser) {
        Gson gson = new Gson();
        String json1 = "{id: '1', name:'y'}";
        User user = gson.fromJson(json1, User.class);
        System.out.println(gson.toJson(user));
        return gson.toJson(pUser);
    }
}
