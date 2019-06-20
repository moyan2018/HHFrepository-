package com.pengfei.framework.systemCode;

import com.pengfei.framework.exception.AbsBaseException;

import java.util.Base64;

class SystemCodeBase64  implements ISystemCode{

    @Override
    public String encode(byte[] contents) throws AbsBaseException {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(contents);
    }

    @Override
    public byte[] decode(String content) throws AbsBaseException {
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(content);
    }
}
