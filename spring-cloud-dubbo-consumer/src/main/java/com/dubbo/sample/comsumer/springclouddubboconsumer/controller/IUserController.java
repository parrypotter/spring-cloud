package com.dubbo.sample.comsumer.springclouddubboconsumer.controller;

import com.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author parry
 */
@RestController
@RequestMapping(value = "/spring/cloud")
public class IUserController {

    @Reference(mock = "com.dubbo.sample.comsumer.springclouddubboconsumer.service.MockService", cluster = "failfast")
    private IUserService iUserService;

    @GetMapping("/start")
    public String IUserControllerStartTesting() {
        return iUserService.getVersion("s");
    }
}
