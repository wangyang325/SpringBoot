package wangyang.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFullController {
    @RequestMapping("/Restful/{id}")
    public String test(@PathVariable String id) {
        return "restful controller" + id;
    }
}
