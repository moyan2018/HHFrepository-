package com.pengfei.framework.exception;

public class SystemCodeException  extends AbsBaseException{

    public SystemCodeException(String message){
        super(message);
    }

    public SystemCodeException(Exception exception){
        super(exception);
    }

    @Override
    protected String getModelName() {
        return "系统编码";
    }
}
