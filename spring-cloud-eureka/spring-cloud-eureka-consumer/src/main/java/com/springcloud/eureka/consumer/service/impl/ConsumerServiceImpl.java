package com.springcloud.eureka.consumer.service.impl;

import com.springcloud.eureka.consumer.feign.CustomerFeign;
import com.springcloud.eureka.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ConsumerServiceImpl implements ConsumerService {


    @Value("${spring.application.name}")
    private String hostName;

    @Value("${server.port}")
    private int port;


    @Autowired
    private CustomerFeign customerFeign;

    @Override
    public Map<String, Object> getEurekaClientResult() {
        return customerFeign.getEurekaClientResult(hostName, port);
    }
}
