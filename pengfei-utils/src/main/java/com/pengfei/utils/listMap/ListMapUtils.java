package com.pengfei.utils.listMap;

import com.pengfei.framework.listMap.IListMapTree;
import com.pengfei.framework.listMap.IListToMap;
import com.pengfei.framework.listMap.ListMapManager;

import java.util.List;
import java.util.Map;

public final class ListMapUtils {

    private ListMapUtils(){

    }

    public static <T> Map<String, T> listToMap(List<T> tList, IListToMap<T> listToMap) throws Exception{
        return ListMapManager.listToMap(tList, listToMap);
    }

    public static <T> Map<String, List<T>> listToMapList(List<T> tList, IListToMap<T> listToMap) throws Exception{
        return ListMapManager.listToMapList(tList, listToMap);
    }

    public static <T> Map<String, T> listMapTree(List<T> tList, IListMapTree<T> listMapTree) throws Exception{
        return ListMapManager.listMapTree(tList, listMapTree);
    }

    public static <T> Map<String, List<T>> listMapTreeList(List<T> tList, IListMapTree<T> listMapTree) throws Exception{
        return ListMapManager.listMapTreeList(tList, listMapTree);
    }

}
