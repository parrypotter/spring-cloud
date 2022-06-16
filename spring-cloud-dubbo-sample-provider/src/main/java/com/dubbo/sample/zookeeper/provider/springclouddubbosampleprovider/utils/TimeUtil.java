package com.dubbo.sample.zookeeper.provider.springclouddubbosampleprovider.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TimeUtil 自定义时间处理工具类
 * @author 潘锐
 * @date 2021/7/27 23:24
 */
public class TimeUtil {

    private static final ThreadLocal<DateFormat> SIMPLE = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    /**
     * time 获取当前时间
     * @return String
     * @author 潘锐
    */
    public static String time(){
        long timestamp = System.currentTimeMillis();
        Date date = new Date(timestamp);
        return SIMPLE.get().format(date);
    }

    /**
     * time Date时间戳格式化
     * @param date
     * @return String
     * @author 潘锐
    */
    public static String time(Date date){
        return SIMPLE.get().format(date);
    }

    /**
     * createDate long时间戳转Date
     * @param timestamp
     * @return Date
     * @author 潘锐
    */
    public static Date createDate(long timestamp){ return new Date(timestamp);}

    /**
     * getCurrentDateTime
     * @return java.util.Date
     * @author 潘锐
     */
    public static Date getCurrentDateTime() throws ParseException{
        long timestamp = System.currentTimeMillis();
        Date date = new Date(timestamp);
        String time = SIMPLE.get().format(date);
        return SIMPLE.get().parse(time);
    }

    public static void remove(){
        SIMPLE.remove();
    }

}
