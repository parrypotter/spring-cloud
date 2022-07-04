package com.springcloud.eureka.consumer.controller;


import com.springcloud.eureka.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @author parry
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getEurekaClientResult() {
        return new ResponseEntity<> (consumerService.getEurekaClientResult(), HttpStatus.OK);
    }


}
