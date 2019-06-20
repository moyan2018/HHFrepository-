package com.pengfei.framework.exception;

public class JsonException extends AbsBaseException {

    public JsonException(String message){
        super(message);
    }

    public JsonException(Exception exception){
        super(exception);
    }

    @Override
    protected String getModelName() {
        return "Json模块";
    }
}
