package com.springcloud.controller;

import com.netflix.discovery.DiscoveryClient;
import com.springcloud.common.springcloudcommon.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumerCtrl {

    @Autowired
    private RestTemplate restTemplate;

    //private static final String REST_URL = "http://localhost:8001";
    private static final String REST_URL = "http://SPRINGCLOUD-PROVIDER";

    @RequestMapping("/consumer/service1")
    @ResponseBody
    public String consumerService() {
        UserBean user = new UserBean();
        user.setId("001");
        user.setName("wy");
        return restTemplate.postForObject(REST_URL + "/provider/service1", user, String.class);
    }

    @RequestMapping("/consumer/service1/name")
    @ResponseBody
    public String serviceName() {
        return restTemplate.getForObject(REST_URL + "/provider/service1/name", String.class);
    }

    @RequestMapping("/name")
    @ResponseBody
    public String name() {
        return restTemplate.getForObject(REST_URL + "/name", String.class);
    }

    @RequestMapping("/consumer/service1/discovery")
    @ResponseBody
    public String consumerServiceDiscovery() {
        DiscoveryClient client = restTemplate.postForObject(REST_URL + "/provider/service1/discovery", null , DiscoveryClient.class);
        return client.toString();
    }
}
