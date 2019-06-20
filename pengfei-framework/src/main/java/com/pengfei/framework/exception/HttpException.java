package com.pengfei.framework.exception;

public class HttpException extends AbsBaseException {

    public HttpException(String message){
        super(message);
    }

    public HttpException(Exception exception){
        super(exception);
    }

    @Override
    protected String getModelName() {
        return "http请求模块";
    }
}
