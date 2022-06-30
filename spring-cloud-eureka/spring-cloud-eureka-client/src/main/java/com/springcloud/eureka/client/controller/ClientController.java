package com.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潘锐
 * @date 2022/6/30 23:45
 * ClientController
 */

@RestController
@RequestMapping(value = "/client")
public class ClientController {


    @Value("${server.port}")
    private String host;

    @Value("${spring.application.name}")
    private String instanceName;

    @GetMapping("/getClientInfo")
    public String getClientInfo(){
        return "客户端,服务名："+instanceName+"，端口为："+host;
    }

}
