package com.pengfei.framework.exception;

public enum  EnExceptionLevel {

    Info("info", "正常输出"),
    Exception("exception", "异常输出"),
    Warning("warning", "警告输出"),
    Error("error", "重大错误")
    ;

    EnExceptionLevel(String code, String desc){
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
