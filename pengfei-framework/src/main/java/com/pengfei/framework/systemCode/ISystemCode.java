package com.pengfei.framework.systemCode;


import com.pengfei.framework.exception.AbsBaseException;

public interface ISystemCode {

    String encode(byte[] contents) throws AbsBaseException;

    byte[] decode(String content) throws AbsBaseException;
}
