package com.springcloud.eureka.consumer.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@FeignClient(value = "SPRING-CLOUD-EUREKA-CLIENT", url = "http://101.35.104.222:9000")
public interface CustomerFeign {

    @GetMapping("/client/getClientInfo")
    Map<String, Object> getEurekaClientResult(@RequestParam(value = "hostName") String hostName, @RequestParam(value = "port") int port);



}
