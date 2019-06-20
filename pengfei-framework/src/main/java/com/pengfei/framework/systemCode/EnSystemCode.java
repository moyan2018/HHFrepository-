package com.pengfei.framework.systemCode;

public enum EnSystemCode {

    Hex("hex", "十六进制编码", new SystemCodeHex()),
    Base_64("base64", "Base64编码", new SystemCodeBase64())
    ;

    EnSystemCode(String code, String desc, ISystemCode systemCode){
        this.setCode(code);
        this.setDesc(desc);
        this.setSystemCode(systemCode);
    }

    private String code;
    private String desc;
    private ISystemCode systemCode;

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

    public ISystemCode getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(ISystemCode systemCode) {
        this.systemCode = systemCode;
    }
}
