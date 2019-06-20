package com.pengfei.utils.json;

import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.json.JsonManager;

public final class JsonUtils {

    private JsonUtils(){

    }

    public static <T> String toJson(T target) throws AbsBaseException {
        return JsonManager.toJson(target);
    }

    public static <T> String toJsonStyle(T target) throws AbsBaseException {
        return JsonManager.toJsonStyle(target);
    }

    public static <T> T fromJson(String json, Class<T> tClass) throws AbsBaseException {
        return JsonManager.fromJson(json, tClass);
    }
}
