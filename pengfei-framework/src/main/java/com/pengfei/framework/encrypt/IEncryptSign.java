package com.pengfei.framework.encrypt;

import com.pengfei.framework.exception.AbsBaseException;

interface IEncryptSign {

    byte[] sign(byte[] contents, byte[] publicKey) throws AbsBaseException, AbsBaseException;

    boolean verify(byte[] contents, byte[] publicKey, byte[] sign) throws AbsBaseException;
}
