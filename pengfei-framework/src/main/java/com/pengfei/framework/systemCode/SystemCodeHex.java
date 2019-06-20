package com.pengfei.framework.systemCode;

import com.pengfei.framework.exception.AbsBaseException;
import org.apache.commons.codec.binary.Hex;

public class SystemCodeHex implements ISystemCode {

    @Override
    public String encode(byte[] contents) throws AbsBaseException {
        return Hex.encodeHexString(contents);
    }

    @Override
    public byte[] decode(String content) throws AbsBaseException {
        try {
            return Hex.decodeHex( content );
        } catch (Exception e){
            SystemCodeManager.handleException(e);
            return null;
        }
    }
}
