package com.pengfei.framework;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class FrameWorkCommon {

    private FrameWorkCommon(){

    }

    // 为空判定
    public static <T> boolean isEmpty(T empty){

        if( empty == null ) return true;

        if( empty instanceof String ){
            String str = (String) empty;
            return "".equals(str.trim());
        }

        if( empty instanceof List){
            List list = (List) empty;
            return list.isEmpty();
        }

        if( empty instanceof Map){
            Map map = (Map) empty;
            return map.isEmpty();
        }

        if( empty.getClass().isArray() ){
            return Array.getLength( empty ) == 0;
        }

        return false;
    }

    // 不为空判定
    public static <T> boolean isNotEmpty(T empty){
        return !isEmpty(empty);
    }

    // 默认系统编码
    public static final String Default_Charset = "utf-8";

    // 讲byte[]数组按指定大小分成多少分
    public static List<byte[]> splitBytes(byte[] bytes, int split){
        if( isEmpty(bytes) ) return null;
        List<byte[]> byteList = new ArrayList<>();
        if( split <= 0 || split > bytes.length ) {
            byteList.add( bytes );
            return byteList;
        }
        int index = 0;
        byte[] bts = null;
        for(int i = 0; i < bytes.length; i++){
            if( bts == null ){
                if( i + split < bytes.length ){
                    bts = new byte[split];
                } else {
                    bts = new byte[bytes.length - i];
                }
            }
            bts[index++] = bytes[i];
            if( index >= bts.length ){
                byteList.add( bts );
                index = 0;
                bts = null;
            }
        }
        if( bts != null ){
            byteList.add( bts );
        }
        return byteList;
    }

    // 往list中添加byte数组
    public static void addList(List<Byte> byteList, byte[] bytes){
        if( byteList == null ) return;
        if( isEmpty(bytes) ) return;
        for(byte bt : bytes){
            byteList.add( bt );
        }
    }

    // 获取字节流数组
    public static byte[] getBytes(List<Byte> byteList){
        if( isEmpty(byteList) ) return new byte[0];
        byte[] bytes = new byte[byteList.size()];
        for(int i = 0; i < byteList.size(); i++){
            bytes[i] = byteList.get(i);
        }
        return bytes;
    }
}
