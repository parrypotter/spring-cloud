package com.dubbo.sample.zookeeper.provider.springclouddubbosampleprovider.service;

import com.dubbo.sample.zookeeper.provider.springclouddubbosampleprovider.constant.JwtConstant;
import com.dubbo.sample.zookeeper.provider.springclouddubbosampleprovider.utils.TimeUtil;
import com.service.IUserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * @author parry
 */
@Service(cluster = "failfast", loadbalance = "roundrobin")
public class IUserServiceImpl implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IUserServiceImpl.class);

    @Value("${spring.application.name}")
    private String applicationName;


    /**
     * generateToken 生成token信息并返回
     * @param  map map标签
     * @return String
     */
    @Override
    public String generateToken(Map<String, Object> map) {
        map = Objects.isNull(map)?new HashMap<>(16):map;
        Date date = TimeUtil.createDate(System.currentTimeMillis()+ JwtConstant.EXPIRATION_TIME*1000);
        LOGGER.info("过期时间：{}", TimeUtil.time(date));
        /**利用jsonwebtoken生成token*/
        String jwt = Jwts.builder().setClaims(map).setExpiration(date).signWith(SignatureAlgorithm.HS512, JwtConstant.SECRET).compact();
        LOGGER.info("生成的Token:{}", jwt);
        /**存入缓存*/
        return String.format("[%s] has jwt witch is [%s]", applicationName, jwt);
    }

    /**
     *validateTokenAndGetClaims 检验并解析token
     * @param token token字符串
     * @return java.lang.Object
     * @throws IllegalArgumentException:JWT字符串参数不能为空或null。
     * //@throws SignatureException :字符串伪造 并不是服务端颁发的token
     * //@throws MalformedJwtException :字符串缺失
     * @throws ExpiredJwtException：token已过期
     * @throws UnsupportedJwtException:未知
     */
    @Override
    public Map<String, Object> validateTokenAndGetClaims(String token) throws ExpiredJwtException, UnsupportedJwtException {
        return Jwts.parser().setSigningKey(JwtConstant.SECRET).parseClaimsJws(token.replace(applicationName, "")).getBody();
    }


    /**
     * setHeader 设置 Authentication
     * @param response
     * @param jwt
     */
    @Override
    public void setHeader(HttpServletResponse response, String jwt) {
        /**添加jwt至返回流*/
        response.setHeader(JwtConstant.ACCESS_CONTROL_EXPOSE_HEADERS, JwtConstant.HEADER_NAME);
        response.setHeader(JwtConstant.HEADER_NAME, jwt);
    }
}
