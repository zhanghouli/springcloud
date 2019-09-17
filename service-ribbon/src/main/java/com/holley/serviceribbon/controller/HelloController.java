package com.holley.serviceribbon.controller;

import com.holley.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-09-16 10:55
 **/
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String hi(@RequestParam("name")String name){
        return helloService.hiService(name);
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hystrixTest(@RequestParam("name")String name){
        return helloService.hystrixTextService(name);
    }
}
