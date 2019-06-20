package com.pengfei.framework.encrypt;

import com.pengfei.framework.exception.AbsBaseException;

import java.security.MessageDigest;

abstract class AbsEncrypt implements IEncrypt {

    protected abstract String getInstance();

    /**
     * 首先将数据用MD5加密
     */
    @Override
    public byte[] encrypt(byte[] contents) throws AbsBaseException {
        try {
            MessageDigest digest = MessageDigest.getInstance( this.getInstance() );
            digest.update( contents );
            return digest.digest();
        } catch (Exception e){
            EncryptManager.handleException(e);
            return null;
        }
    }
}
