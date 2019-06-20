package com.pengfei.framework.encrypt;

class EncryptSignSHA1withRSA extends AbsEncryptSign {

    @Override
    protected String getInstance() {
        return "RSA";
    }

    @Override
    protected String getInstanceSign() {
        return "SHA1withRSA";
    }
}
