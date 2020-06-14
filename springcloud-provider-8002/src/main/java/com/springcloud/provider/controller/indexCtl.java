package com.springcloud.provider.controller;

import com.springcloud.common.springcloudcommon.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class indexCtl {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/provider/service1", method = RequestMethod.POST)
    @ResponseBody
    public String serviceProvider(@RequestBody UserBean user) {
        return "This a service from provider and get data from consumer User Id: " + user.getId() + "  Name :" + user.getName();
    }

    @RequestMapping(value = "/name")
    @ResponseBody
    public String name() {
        return "This is the provider 8002";
    }

    @RequestMapping(value = "/provider/service1/name", method = RequestMethod.GET)
    @ResponseBody
    public String serviceName() {
        return "I am service1 : 8002";
    }

    @RequestMapping(value = "/provider/service1/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();

        List<ServiceInstance> listServices = discoveryClient.getInstances("");
        for (ServiceInstance si : listServices) {
            String info = si.getServiceId() + si.getHost() + si.getPort()+ si.getUri();
        }
        return discoveryClient;
    }
}
