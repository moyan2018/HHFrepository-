package com.pengfei.framework.exception;

public class EncryptException  extends AbsBaseException {

    public EncryptException(String message){
        super(message);
    }

    public EncryptException(Exception exception){
        super(exception);
    }

    @Override
    protected String getModelName() {
        return "加密算法";
    }

}
