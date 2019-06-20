package com.pengfei.framework.okhttp;

import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.exception.HttpException;
import okhttp3.Response;

public final class OKHttpManager {

    private OKHttpManager(){

    }

    public static Response get(String url) throws AbsBaseException {
        try {
            return new OKHttpImpl(url).get();
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    public static String getString(String url) throws AbsBaseException{
        try {
            return get(url).body().string();
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static Response post(String url, String requestBody) throws AbsBaseException{
        try {
            return new OKHttpImpl(url).createBody(requestBody).post();
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    public static String postString(String url, String requestBody) throws AbsBaseException{
        try {
            return post(url, requestBody).body().string();
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static IOKHttp okHttp(String url) throws Exception{
        return new OKHttpImpl(url);
    }

    static void handleException(Exception exception) throws AbsBaseException {
        if( exception instanceof AbsBaseException){
            throw (AbsBaseException) exception;
        } else {
            throw new HttpException(exception);
        }
    }

}
