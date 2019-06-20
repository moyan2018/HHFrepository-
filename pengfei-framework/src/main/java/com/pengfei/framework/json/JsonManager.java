package com.pengfei.framework.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.exception.JsonException;

public final class JsonManager {

    private static ObjectMapper Mapper_Style = new ObjectMapper();
    private static ObjectMapper Mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        Mapper_Style.enable(SerializationFeature.INDENT_OUTPUT);
        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        Mapper_Style.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonManager(){

    }

    public static <T> String toJson(T target) throws AbsBaseException {
        try {
            return Mapper.writeValueAsString(target);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static <T> String toJsonStyle(T target) throws AbsBaseException{
        try {
            return Mapper_Style.writeValueAsString(target);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static <T> T fromJson(String json, Class<T> tClass) throws AbsBaseException{
        try {
            return Mapper.readValue(json, tClass);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    static void handleException(Exception exception) throws AbsBaseException{
        if( exception instanceof AbsBaseException){
            throw (AbsBaseException) exception;
        } else {
            throw new JsonException(exception);
        }
    }
}
