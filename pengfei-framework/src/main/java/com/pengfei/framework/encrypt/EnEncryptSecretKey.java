package com.pengfei.framework.encrypt;

public enum EnEncryptSecretKey {

    AES_128("AES128", "AES 128位加密算法", new EncryptSecretKeyAES(128)),
    AES_256("AES256", "AES 256位加密算法", new EncryptSecretKeyAES(256)),
    DES("DES", "DES 56加密算法", new EncryptSecretKeyDES("DES", 56)),
    DES_3("3DES", "DES 168加密算法", new EncryptSecretKeyDES("3DES", 168))
    ;

    EnEncryptSecretKey(String code, String desc, IEncryptSecretKey encryptSecretKey){
        this.setCode(code);
        this.setDesc(desc);
        this.setEncryptSecretKey(encryptSecretKey);
    }

    private String code;
    private String desc;
    private IEncryptSecretKey encryptSecretKey;

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

    public IEncryptSecretKey getEncryptSecretKey() {
        return encryptSecretKey;
    }

    public void setEncryptSecretKey(IEncryptSecretKey encryptSecretKey) {
        this.encryptSecretKey = encryptSecretKey;
    }
}
