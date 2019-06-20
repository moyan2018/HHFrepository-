package com.pengfei.framework.encrypt;

class EncryptSecretKeyAES extends AbsEncryptSecretKey{

    private int initLength;

    public EncryptSecretKeyAES(int initLength){
        this.initLength = initLength;
    }

    @Override
    protected String getInstance() {
        return "AES";
    }

    @Override
    protected int getInitLength() {
        return initLength;
    }
}
