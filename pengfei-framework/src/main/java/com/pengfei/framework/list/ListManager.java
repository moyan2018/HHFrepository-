package com.pengfei.framework.list;


import com.pengfei.framework.FrameWorkCommon;

import java.util.ArrayList;
import java.util.List;

public final class ListManager {

    private ListManager(){

    }

    public static <T> String ListToString(List<T> tList, IListString<T> listString, String emptyDefault, String contact) throws Exception{
        if( FrameWorkCommon.isEmpty(listString) ) throw new Exception("listString不能为空");
        if( FrameWorkCommon.isEmpty(emptyDefault)  ) emptyDefault = "-";
        if( FrameWorkCommon.isEmpty(contact) ) contact = " ";
        if( FrameWorkCommon.isEmpty(tList) ) return null;
        String str, result = "";
        T t;
        for(int i = 0; i < tList.size(); i++){
            t = tList.get(i);
            str = listString.getString(t);
            if( str == null ){
                str = emptyDefault;
            }
            if( i == 0 ){
                result += str;
            } else {
                result += contact + str;
            }
        }
        return result;
    }

    public static void polishing(List... lists) throws Exception{
        int length = 0;
        List list;
        for(int i = 0; i < lists.length; i++){
            list = lists[i];
            if( FrameWorkCommon.isEmpty(list) ) continue;
            if( list.size() > length ){
                length = list.size();
            }
        }
        for(int i = 0; i < lists.length; i++){
            list = lists[i];
            if( FrameWorkCommon.isEmpty(list) ) continue;
            while( list.size() < length ){
                list.add( list.get(list.size() - 1) );
            }
        }
    }

    public static <T> List<T> accretion(List<T> tList, IListAccretion<T> listAccretion) throws Exception{
        if( FrameWorkCommon.isEmpty(listAccretion) ) return tList;
        if( FrameWorkCommon.isEmpty(tList) ) return tList;
        List<T> listData = new ArrayList<>();
        List<String> list;
        for(T t : tList){
            list = listAccretion.accretionList(t);
            if( FrameWorkCommon.isEmpty(list) ) {
                listData.add( t );
                continue;
            }
            listData.addAll( listAccretion.accretion(list, t) );
        }
        return listData;
    }

    public static List<String> getList(String[] arr) throws Exception{
        if( FrameWorkCommon.isEmpty(arr) ) return null;
        List<String> list = new ArrayList<>();
        for(String str : arr){
            if( FrameWorkCommon.isEmpty(str) ) continue;
            list.add( str );
        }
        return list;
    }

    public static <T> void show(List<T> tList, IListShow<T> listShow) throws Exception{
        if( FrameWorkCommon.isEmpty(listShow) ) return;
        if( FrameWorkCommon.isEmpty(tList) ) return;
        for(T t : tList){
            listShow.show(t);
        }
    }

}
