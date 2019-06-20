package com.pengfei.framework.exception;

public class UnloginException extends AbsBaseException{

    public UnloginException(){
        super("账号没有登录");
    }

    public UnloginException(String message){
        super(message);
    }

    public UnloginException(Exception exception){
        super(exception);
    }

    @Override
    protected String getModelName() {
        return "登录";
    }
}
