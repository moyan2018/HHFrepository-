package com.pengfei.framework.encrypt;

import com.pengfei.framework.exception.AbsBaseException;

interface IEncrypt {

    byte[] encrypt(byte[] contents) throws AbsBaseException, AbsBaseException;
}
