package com.pengfei.framework.encrypt;

public enum EnEncrypt {

    MD5("md5", "MD5算法", new EncryptMD5()),
    SHA("sha", "SHA算法", new EncryptSHA()),
    SHA_1("sha-1", "SHA-1算法", new EncryptSHA1())
    ;
    EnEncrypt(String code, String desc, IEncrypt encrypt){
        this.setCode(code);
        this.setDesc(desc);
        this.setEncrypt(encrypt);
    }

    private String code;
    private String desc;
    private IEncrypt encrypt;

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

    public IEncrypt getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(IEncrypt encrypt) {
        this.encrypt = encrypt;
    }
}
