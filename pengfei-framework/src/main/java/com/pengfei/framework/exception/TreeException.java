package com.pengfei.framework.exception;

public class TreeException extends AbsBaseException{

    public TreeException(String message){
        super(message);
    }

    public TreeException(Exception exception){
        super(exception);
    }

    @Override
    protected String getModelName() {
        return "树形模块";
    }
}
