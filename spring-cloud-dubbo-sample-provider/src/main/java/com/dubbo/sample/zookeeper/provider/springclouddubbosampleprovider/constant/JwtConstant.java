package com.dubbo.sample.zookeeper.provider.springclouddubbosampleprovider.constant;

/**
 * @author 潘锐
 * @date 2021/6/6 1:25
 * JwtConstant token加密信息
 */
public class JwtConstant {
    /**
     *设置token过期时间 单位秒
     */
    public static final Long EXPIRATION_TIME=60L;
    /**
     *    加密盐
     */
    public static final String SECRET="A0B1C2D3E4F5G6H7I8J9KALBMCNDOEPFQ0R1S2T3U4V5W6X7Y8Z9";

    /**
     * header中认证字段
     */
    public static final String HEADER_NAME="Authentication";

    /**jwt名称*/
    public static final String TOKEN_NAME="token";

    /**加密Map的用户名key*/
    public static final String TOKEN_PASSWORD="password";

    /**加密Map的密码key*/
    public static final String TOKEN_USERNAME="username";

    /**允许前段跨域请求*/
    public static final String ACCESS_CONTROL_EXPOSE_HEADERS= "Access-Control-Expose-Headers";

}
