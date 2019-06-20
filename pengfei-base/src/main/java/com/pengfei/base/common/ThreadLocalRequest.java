package com.pengfei.base.common;

import javax.servlet.http.HttpServletRequest;

public final class ThreadLocalRequest {

    private ThreadLocalRequest(){

    }

    private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<>();

    public static void set(HttpServletRequest request){
        requestThreadLocal.set(request);
    }

    public static HttpServletRequest get(){
        return requestThreadLocal.get();
    }

    public static void remove(){
        requestThreadLocal.remove();
    }
}
