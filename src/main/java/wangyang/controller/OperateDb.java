package wangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OperateDb {

    @RequestMapping("/update")
    @ResponseBody
    public String update() {
        return "Db Ok";
    }

}
