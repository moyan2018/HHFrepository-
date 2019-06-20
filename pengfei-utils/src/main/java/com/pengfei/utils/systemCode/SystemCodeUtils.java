package com.pengfei.utils.systemCode;

import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.systemCode.EnSystemCode;
import com.pengfei.framework.systemCode.SystemCodeManager;

public final class SystemCodeUtils {

    private SystemCodeUtils(){

    }

    public static String encodeHex(byte[] contents) throws AbsBaseException {
        return encode(contents, EnSystemCode.Hex);
    }

    public static String encodeHex(String content) throws AbsBaseException {
        return encode(content, EnSystemCode.Hex);
    }

    public static byte[] decodeHex(String content) throws AbsBaseException {
        return decode(content, EnSystemCode.Hex);
    }

    public static String encodeBase64(byte[] contents) throws AbsBaseException {
        return encode(contents, EnSystemCode.Base_64);
    }

    public static String encodeBase64(String content) throws AbsBaseException {
        return encode(content, EnSystemCode.Base_64);
    }

    public static byte[] decodeBase64(String content) throws AbsBaseException {
        return decode(content, EnSystemCode.Base_64);
    }

    public static String encode(byte[] contents, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode(contents, enSystemCode);
    }

    public static String encode(String content, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.encode(content, enSystemCode);
    }

    public static byte[] decode(String content, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.decode(content, enSystemCode);
    }

    public static String decodeString(String content, EnSystemCode enSystemCode) throws AbsBaseException {
        return SystemCodeManager.decodeString(content, enSystemCode);
    }

}
