package com.pengfei.base.config;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public final class CommonConfig {

    private CommonConfig(){

    }

    // 导出excel头部设置
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-com.pengfei.base.cache");
            response.addHeader("Cache-Control", "no-com.pengfei.base.cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
