package com.pengfei.framework.okhttp;

public enum  EnCharsetType {

    Charset_utf8("charset=utf-8", "utf-8编码"),
    Charset_ISO_8859_1("charset=ISO-8859-1", "ISO-8859-1编码")
    ;
    EnCharsetType(String code, String desc){
        this.setCode(code);
        this.setDesc(desc);
    }

    private String code;
    private String desc;

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
}
