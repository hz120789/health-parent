package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Reference
    HelloService helloService;

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        return helloService.sayHello(name);
    }
}
