package com.dubbo.sample.comsumer.springclouddubboconsumer.service;

import com.service.IUserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.apache.dubbo.config.annotation.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author parry
 */
@Service
public class MockServiceImpl implements IUserService {


    @Override
    public String generateToken(Map<String, Object> map) {
        return "Mock Service is Loading";
    }

    @Override
    public Map<String, Object> validateTokenAndGetClaims(String jwt) throws ExpiredJwtException, UnsupportedJwtException {
        Map<String, Object> map = new HashMap<>();
        map.put(jwt, "Mock Service is Loading");
        return map;
    }

    @Override
    public void setHeader(HttpServletResponse response, String jwt) {

    }
}
