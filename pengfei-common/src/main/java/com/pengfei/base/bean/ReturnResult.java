package com.pengfei.base.bean;

public class ReturnResult<T> {

    private static final String Default_Result_Success_Code = "200";
    private static final String Default_Result_Error_Code = "201";

    private String code;
    private String message;
    private T data;

    public ReturnResult(){

    }

    public static <T> ReturnResult<T> Success(T data){
        return Success(null, data);
    }

    public static <T> ReturnResult<T> Success(String message){
        return Success(message, null);
    }

    public static <T> ReturnResult<T> Success(String message, T data){
        ReturnResult result = new ReturnResult();
        result.setCode(Default_Result_Success_Code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> ReturnResult<T> Error(String message){
        return Error(Default_Result_Error_Code, message);
    }

    public static <T> ReturnResult<T> Error(String code, String message){
        ReturnResult result = new ReturnResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
