package com.holley.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @author Holley
 * @Description 断路器的回调类
 * @create 2019-09-16 17:52
 **/
@Component
public class FeignHystrixTest implements Hiservice{
    @Override
    public String hi(String name) {
        return "对不起，服务不可用";
    }
}
