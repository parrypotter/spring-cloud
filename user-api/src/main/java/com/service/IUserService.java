package com.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author parry
 */
public interface IUserService {


    /**
     *generateToken 生成token信息并返回
     * @param  claims map标签
     * @return String
     */
    String generateToken(Map<String, Object> claims);

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
    Map<String, Object> validateTokenAndGetClaims(String token) throws ExpiredJwtException, UnsupportedJwtException;

    /**
     * setHeader 设置 Authentication
     * @param response
     * @param jwt
     */
    void setHeader(HttpServletResponse response, String jwt);

}
