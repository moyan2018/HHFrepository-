package com.pengfei.framework.okhttp;

public enum EnMediaType {

    Text_Html("text/html", "HTML格式"),
    Text_Plain("text/plain", "纯文本格式"),
    Text_Xml("text/xml", "XML格式"),
    Image_Gif("image/gif", "gif图片格式"),
    Image_Jpeg("image/jpeg", "jpg图片格式"),
    Image_Png("image/png", "png图片格式"),
    Application_Xhtml_Xml("application/xhtml+xml", "XHTML格式"),
    Application_Xml("application/xml", "XML数据格式"),
    Application_Atom_Xml("application/atom+xml", "Atom XML聚合格式"),
    Application_Json("application/json", "JSON数据格式"),
    Application_Pdf("application/pdf", "pdf格式"),
    Application_Msword("application/msword", "Word文档格式"),
    application_Octet_Stream("application/octet-stream", "二进制流数据")
    ;
    EnMediaType(String code, String desc){
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

    public static EnMediaType getDefaultString(){
        return EnMediaType.Application_Json;
    }

    public static EnMediaType getDefaultFile(){
        return EnMediaType.Text_Plain;
    }
}
