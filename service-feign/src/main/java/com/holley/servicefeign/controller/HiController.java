package com.holley.servicefeign.controller;

import com.holley.servicefeign.service.Hiservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-09-16 15:11
 **/
@RestController
public class HiController {

    @Autowired
    Hiservice hiservice;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return hiservice.hi( name );
    }
}
