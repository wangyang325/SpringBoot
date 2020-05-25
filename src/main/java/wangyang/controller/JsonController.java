package wangyang.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wangyang.service.AsyncService;

import java.util.concurrent.Future;

@Controller
public class JsonController {

    @RequestMapping("/json")
    @ResponseBody
    public String getJsonData() throws Exception {
        //创立JSON对象
        JsonObject object = new JsonObject();

        //添加键值对
        object.addProperty("cat","it");

        //添加数组
        JsonArray array = new JsonArray();

        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id",1);
        lan1.addProperty("name","Java");
        lan1.addProperty("ide","Eclipse");
        array.add(lan1);

        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id",2);
        lan2.addProperty("name","Swift");
        lan2.addProperty("ide","XCode");
        array.add(lan2);

        JsonObject lan3 = new JsonObject();
        lan3.addProperty("id",3);
        lan3.addProperty("name","C#");
        lan3.addProperty("ide","Visual Studio");
        array.add(lan3);

        //将这个数组添加进去
        object.add("languages", array);

        //添加布尔
        object.addProperty("pop", true);

        //输出
        System.out.println(object.toString());
        //int a = 5/0;
        return object.toString();
    }

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/async")
    @ResponseBody
    public String runAsync() throws Exception {
        Future<String> task1 = asyncService.doTask1();
        while (true) {
            if (task1.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        String rs = task1.get();
        System.out.println(rs);
        return rs;
    }
}
