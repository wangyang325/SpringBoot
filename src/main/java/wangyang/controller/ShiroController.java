package wangyang.controller;

import org.apache.shiro.authz.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShiroController {

    @RequestMapping("/shiro")
    @RequiresPermissions(value = {"book:add"}, logical = Logical.AND)
    @RequiresUser()
    @RequiresRoles(value = {"admin"}, logical = Logical.OR)
    @RequiresGuest
    @ResponseBody
    public String shiro() {
        return "";
    }
}
