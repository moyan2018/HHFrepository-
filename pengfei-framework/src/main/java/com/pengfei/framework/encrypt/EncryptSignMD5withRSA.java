package com.pengfei.framework.encrypt;

class EncryptSignMD5withRSA extends AbsEncryptSign {

    @Override
    protected String getInstance() {
        return "RSA";
    }

    @Override
    protected String getInstanceSign() {
        return "MD5withRSA";
    }
}
