package com.pengfei.framework.encrypt;

class EncryptPublicPrivateKeyRSA extends AbsEncryptPublicPrivateKey{

    private int initLength;

    public EncryptPublicPrivateKeyRSA(int initLength){
        this.initLength = initLength;
    }

    @Override
    protected String getInstance() {
        return "RSA";
    }

    @Override
    protected int initLength() {
        return this.initLength;
    }
}
