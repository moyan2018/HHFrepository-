package com.pengfei.base.common;


import com.pengfei.utils.empty.EmptyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class LoginInfoMgr {

    private static String Default_Login_Info_Key = "loginInfo";

    private LoginInfoMgr(){

    }

    public static HttpServletRequest getRequest() throws Exception{
        HttpServletRequest request = ThreadLocalRequest.get();
        if( EmptyUtils.isEmpty(request) ){
            throw new Exception("request is null");
        }
        return request;
    }

    public static HttpServletResponse getResponse() throws Exception{
        HttpServletResponse response = ThreadLocalResponse.get();
        if( EmptyUtils.isEmpty(response) ){
            throw new Exception("response is null");
        }
        return response;
    }

    public static HttpSession getSession() throws Exception{
        return getRequest().getSession();
    }

    public static <T> void setLoginInfo(T loginInfo) throws Exception{
        getSession().setAttribute(Default_Login_Info_Key, loginInfo);
    }

    public static <T> T getLoginInfo(Class<T> tClass) throws Exception{
        return getSession(Default_Login_Info_Key, tClass);
    }

    public static <T> T getSession(String key, Class<T> tClass) throws Exception{
        return tClass.cast( getSession().getAttribute(key) );
    }

    public static int getPort() throws Exception{
        return getRequest().getRemotePort();
    }

    public static String getIp() throws Exception{
        return getRequest().getRemoteHost();
    }

}
