package com.rihanna.mq.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.rihanna.mq.entity.Order;

public class FastJsonConvertUtil {

    public static Order convertJSONToObject(String message, Object obj){
        return JSON.parseObject(message, new TypeReference<Order>() {});
    }

    public static String convertObjectToJSON(Object obj){
        return JSON.toJSONString(obj);
    }
}