package com.pengfei.utils.okhttp;

import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.okhttp.IOKHttp;
import com.pengfei.framework.okhttp.OKHttpManager;
import okhttp3.Response;

public final class OKHttpUtils {

    private OKHttpUtils(){

    }

    public static Response get(String url) throws AbsBaseException {
       return OKHttpManager.get(url);
    }

    public static String getString(String url) throws AbsBaseException {
        return OKHttpManager.getString(url);
    }

    public static Response post(String url, String requestBody) throws AbsBaseException {
        return OKHttpManager.post(url, requestBody);
    }

    public static String postString(String url, String requestBody) throws AbsBaseException {
       return OKHttpManager.postString(url, requestBody);
    }

    public static IOKHttp okHttp(String url) throws Exception{
        return OKHttpManager.okHttp(url);
    }
}
