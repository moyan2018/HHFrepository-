package com.pengfei.utils.list;

import com.pengfei.framework.list.IListAccretion;
import com.pengfei.framework.list.IListShow;
import com.pengfei.framework.list.IListString;
import com.pengfei.framework.list.ListManager;

import java.util.List;

public final class ListUtils {

    private ListUtils(){

    }

    public static <T> String ListToString(List<T> tList, IListString<T> listString, String emptyDefault, String contact) throws Exception{
        return ListManager.ListToString(tList, listString, emptyDefault, contact);
    }

    public static <T> String ListToString(List<T> tList, IListString<T> listString) throws Exception{
        return ListManager.ListToString(tList, listString, "-", " ");
    }

    public static void polishing(List... lists) throws Exception{
        ListManager.polishing(lists);
    }

    public static <T> List<T> accretion(List<T> tList, IListAccretion<T> listAccretion) throws Exception{
        return ListManager.accretion(tList, listAccretion);
    }

    public static List<String> getList(String[] arr) throws Exception{
        return ListManager.getList(arr);
    }

    public static <T> void show(List<T> tList, IListShow<T> listShow) throws Exception{
        ListManager.show(tList, listShow);
    }

}
