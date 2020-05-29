package wangyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
public class KafkaController {
    @RequestMapping("/kafka/{msg}")
    @ResponseBody
    public void sendMsg(@PathVariable String msg) throws Exception {

    }
}
