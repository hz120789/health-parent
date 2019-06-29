package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = HelloService.class)
@Transactional
public class HelloServiceImpl implements HelloService {

    @Autowired
    TestMapper testMapper;

    @Override
    public String sayHello(String name) {
        String result = "hello"+name;
        result = testMapper.getUserName(1);
        return result + "," + name;
    }
}
