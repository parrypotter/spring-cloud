package com.dubbo.sample.zookeeper.provider.springclouddubbosampleprovider.service;

import com.service.IUserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author parry
 */
@Service(cluster = "failfast", loadbalance = "roundrobin")
public class IUserServiceImpl implements IUserService {


    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public String getVersion(String s) {
        return String.format("Spring Cloud Dubbo Version is [%s] and input is [%s]", applicationName, s);
    }

    @Override
    public String mergeVersionInfo(List<String> list) {
        return list.stream().map(String::toString).collect(Collectors.joining(","));
    }
}
