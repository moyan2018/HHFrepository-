package com.pengfei.framework.exception;

public class ConfigException extends AbsBaseException {

    public ConfigException(String message){
        super(message);
    }

    public ConfigException(Exception exception){
        super(exception);
    }

    @Override
    protected String getModelName() {
        return "配置信息异常";
    }

    @Override
    protected EnExceptionLevel getExceptionLevel() {
        return EnExceptionLevel.Error;
    }
}
