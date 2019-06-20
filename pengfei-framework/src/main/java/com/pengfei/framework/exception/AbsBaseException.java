package com.pengfei.framework.exception;

public abstract class AbsBaseException extends Exception {


    public AbsBaseException(String message){
        super(message);
    }

    public AbsBaseException(Exception exception){
        super(exception);
    }

    protected EnExceptionLevel getExceptionLevel(){
        return EnExceptionLevel.Exception;
    }

    protected  abstract String getModelName();

}
