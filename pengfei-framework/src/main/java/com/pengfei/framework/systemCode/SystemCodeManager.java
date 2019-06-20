package com.pengfei.framework.systemCode;


import com.pengfei.framework.FrameWorkCommon;
import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.exception.SystemCodeException;

public final class SystemCodeManager {

    private SystemCodeManager(){

    }

    public static String encode(byte[] contents, EnSystemCode enSystemCode) throws AbsBaseException {
        enSystemCode = getEnSystemCode(enSystemCode);
        return enSystemCode.getSystemCode().encode(contents);
    }

    public static String encode(String content, EnSystemCode enSystemCode) throws AbsBaseException{
        enSystemCode = getEnSystemCode(enSystemCode);
        try {
            return enSystemCode.getSystemCode().encode(content.getBytes(FrameWorkCommon.Default_Charset));
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    public static byte[] decode(String content, EnSystemCode enSystemCode) throws AbsBaseException{
        enSystemCode = getEnSystemCode(enSystemCode);
        return enSystemCode.getSystemCode().decode(content);
    }

    public static String decodeString(String content, EnSystemCode enSystemCode) throws AbsBaseException{
        enSystemCode = getEnSystemCode(enSystemCode);
        try {
            return new String(enSystemCode.getSystemCode().decode(content), FrameWorkCommon.Default_Charset);
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    private static EnSystemCode getEnSystemCode(EnSystemCode enSystemCode){
        if( enSystemCode == null ){
            enSystemCode = EnSystemCode.Base_64;
        }
        return enSystemCode;
    }

    static void handleException(Exception exception) throws AbsBaseException {
        if( exception instanceof AbsBaseException){
            throw (AbsBaseException) exception;
        } else {
            throw new SystemCodeException(exception);
        }
    }
}
