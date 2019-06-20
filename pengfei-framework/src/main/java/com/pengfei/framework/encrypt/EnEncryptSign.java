package com.pengfei.framework.encrypt;

public enum EnEncryptSign {

    MD5_With_RSA("MD5withRSA", "MD5withRSA数字签名算法", new EncryptSignMD5withRSA()),
    SHA1_With_RSA("SHA1withRSA", "SHA1withRSA数字签名算法", new EncryptSignSHA1withRSA())
    ;

    EnEncryptSign(String code, String desc, IEncryptSign encryptSign){
        this.setCode(code);
        this.setDesc(desc);
        this.setEncryptSign(encryptSign);
    }

    private String code;
    private String desc;
    private IEncryptSign encryptSign;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public IEncryptSign getEncryptSign() {
        return encryptSign;
    }

    public void setEncryptSign(IEncryptSign encryptSign) {
        this.encryptSign = encryptSign;
    }
}
