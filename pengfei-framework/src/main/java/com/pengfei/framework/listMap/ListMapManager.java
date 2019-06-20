package com.pengfei.framework.listMap;

import com.pengfei.framework.FrameWorkCommon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class ListMapManager {

    private ListMapManager(){

    }

    public static <T> Map<String, T> listToMap(List<T> tList, IListToMap<T> listToMap) throws Exception{
        if( FrameWorkCommon.isEmpty(listToMap) ) throw new Exception("listToMap不能为空");
        if( FrameWorkCommon.isEmpty(tList) ) return null;
        Map<String, T> map = new TreeMap<>();
        String key;
        for(T t : tList){
            key = listToMap.getKey(t);
            if( FrameWorkCommon.isEmpty(key) ) continue;
            map.put(key, t);
        }
        return map;
    }

    public static <T> Map<String, List<T>> listToMapList(List<T> tList, IListToMap<T> listToMap) throws Exception{
        if( FrameWorkCommon.isEmpty(listToMap) ) throw new Exception("listToMap不能为空");
        if( FrameWorkCommon.isEmpty(tList) ) return null;
        Map<String, List<T>> mapList = new TreeMap<>();
        String key;
        for(T t : tList){
            key = listToMap.getKey(t);
            if(FrameWorkCommon.isEmpty(key) ) continue;
            if( !mapList.containsKey(key) ){
                mapList.put(key, new ArrayList<>());
            }
            mapList.get(key).add(t);
        }
        return mapList;
    }

    public static <T> Map<String, T> listMapTree(List<T> tList, IListMapTree<T> listMapTree) throws Exception{
        if( FrameWorkCommon.isEmpty(listMapTree) ) throw new Exception("listMapTree不能为空");
        if( FrameWorkCommon.isEmpty(tList) ) return null;
        Map<String, T> map = listToMap(tList, listMapTree);
        if( FrameWorkCommon.isEmpty(map) ) return null;
        String parentKey;
        T t;
        for(String key : map.keySet()){
            t = map.get(key);
            parentKey = listMapTree.getParentKey(t);
            if( FrameWorkCommon.isEmpty(parentKey) ) continue;
            if( !map.containsKey(parentKey) ) continue;
            listMapTree.setChildren( map.get(parentKey), t );

        }
        return map;
    }

    public static <T> Map<String, List<T>> listMapTreeList(List<T> tList, IListMapTree<T> listMapTree) throws Exception{
        if( FrameWorkCommon.isEmpty(listMapTree) ) throw new Exception("listMapTree不能为空");
        if( FrameWorkCommon.isEmpty(tList) ) return null;
        Map<String, List<T>> mapList = listToMapList(tList, listMapTree);
        if( FrameWorkCommon.isEmpty(mapList) ) return null;
        String parentKey;
        List<T> ts;
        for(String key : mapList.keySet()){
            ts = mapList.get(key);
            for(T t : ts){
                parentKey = listMapTree.getParentKey(t);
                if( FrameWorkCommon.isEmpty(parentKey) ) continue;
                if( !mapList.containsKey(parentKey) ) continue;
                for(T t1 : mapList.get(parentKey) ){
                    listMapTree.setChildren( t1, t );
                }
            }
        }
        return mapList;
    }

}
