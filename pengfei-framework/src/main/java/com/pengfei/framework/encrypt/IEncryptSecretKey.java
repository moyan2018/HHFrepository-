package com.pengfei.framework.encrypt;

import com.pengfei.framework.exception.AbsBaseException;

interface IEncryptSecretKey {

    byte[] generateKey() throws AbsBaseException, AbsBaseException;

    byte[] encryptSecretKey(byte[] contents, String secretKey) throws AbsBaseException;

    byte[] decryptSecretKey(byte[] contents, String secretKey) throws AbsBaseException;

}
