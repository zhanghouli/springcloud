package com.holley.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-09-16 15:09
 **/
@FeignClient(value = "eureka-client",fallback = FeignHystrixTest.class)
@Component
public interface Hiservice {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String hi(@RequestParam(value = "name") String name);
}
