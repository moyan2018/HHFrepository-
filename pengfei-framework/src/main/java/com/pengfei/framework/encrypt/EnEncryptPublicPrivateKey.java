package com.pengfei.framework.encrypt;

public enum EnEncryptPublicPrivateKey {

    RSA_512("RSA_512", "RSA 512位加密算法", new EncryptPublicPrivateKeyRSA(512)),
    RSA_1024("RSA_1024", "RSA 1024位加密算法", new EncryptPublicPrivateKeyRSA(1024)),
    RSA_2048("RSA_2048", "RSA 2048位加密算法", new EncryptPublicPrivateKeyRSA(2048))
    ;

    EnEncryptPublicPrivateKey(String code, String desc, IEncryptPublicPrivateKey publicPrivateKey){
        this.setCode(code);
        this.setDesc(desc);
        this.setPublicPrivateKey(publicPrivateKey);
    }

    private String code;
    private String desc;
    private IEncryptPublicPrivateKey publicPrivateKey;

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

    public IEncryptPublicPrivateKey getPublicPrivateKey() {
        return publicPrivateKey;
    }

    public void setPublicPrivateKey(IEncryptPublicPrivateKey publicPrivateKey) {
        this.publicPrivateKey = publicPrivateKey;
    }
}
