package com.holley.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-09-16 10:50
 **/
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name){
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }

    @HystrixCommand(fallbackMethod = "error")
    public String hystrixTextService(String name){
        return restTemplate.getForObject("http://eureka-client/test?name="+name,String.class);
    }
    /**
      * @Author holley
      * @Description 断路器回调函数
      * @Date 2019/9/16 17:40
      * @Param [name]
      * @return java.lang.String
      */
    public String error(String name){
        return "hi,"+name+",sorry,error!";
    }
}
