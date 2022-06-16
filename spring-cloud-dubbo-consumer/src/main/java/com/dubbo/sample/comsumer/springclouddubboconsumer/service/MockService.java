package com.dubbo.sample.comsumer.springclouddubboconsumer.service;

import com.service.IUserService;

import java.util.List;

/**
 * @author parry
 */
public class MockService implements IUserService {
    @Override
    public String getVersion(String s) {
        return "Mock Service is Loading";
    }

    @Override
    public String mergeVersionInfo(List<String> list) {
        return "Mock Service is Loading";
    }
}
