package com.pengfei.base.common;

import javax.servlet.http.HttpServletResponse;

public final class ThreadLocalResponse {

    private ThreadLocalResponse(){

    }

    private static ThreadLocal<HttpServletResponse> requestThreadLocal = new ThreadLocal<>();

    public static void set(HttpServletResponse response){
        requestThreadLocal.set(response);
    }

    public static HttpServletResponse get(){
        return requestThreadLocal.get();
    }

    public static void remove(){
        requestThreadLocal.remove();
    }
}
