package com.dubbo.sample.comsumer.springclouddubboconsumer.controller;

import com.alibaba.fastjson2.JSON;
import com.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author parry
 */
@RestController
@RequestMapping(value = "/spring/cloud")
public class IUserController {

    @Reference(mock = "com.dubbo.sample.comsumer.springclouddubboconsumer.service.MockServiceImpl", cluster = "failfast")
    private IUserService iUserService;


    @PostMapping("/generateToken")
    public ResponseEntity<String> generateToken(@RequestBody String params) {
        Map<String, Object> map = JSON.parseObject(params);
        return new ResponseEntity(iUserService.generateToken(map), HttpStatus.OK);
    }
}
