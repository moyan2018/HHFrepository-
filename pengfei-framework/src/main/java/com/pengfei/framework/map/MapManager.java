package com.pengfei.framework.map;

import com.pengfei.framework.FrameWorkCommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapManager {

    private MapManager(){

    }

    public static <T> void show(Map<String, T>  tMap, IMapShow<T> mapShow) throws Exception{
        if( FrameWorkCommon.isEmpty(tMap) ) return;
        if( FrameWorkCommon.isEmpty(mapShow) ) return;
        for(String key : tMap.keySet()){
            mapShow.show(key, tMap.get(key));
        }
    }

    public static <T> void showSift(Map<String, T> tMap, IMapShow<T> mapShow) throws Exception{
        if( FrameWorkCommon.isEmpty(tMap) ) return;
        if( FrameWorkCommon.isEmpty(mapShow) ) return;
        List<String> keyList = new ArrayList<>();
        for(String key : tMap.keySet()){
            try {
                mapShow.show(key, tMap.get(key));
            } catch (Exception e){
                keyList.add( key );
            }
        }
        if( FrameWorkCommon.isEmpty(keyList) ) return;
        for(String key : keyList){
            tMap.remove(key);
        }
    }

    public static <T> List<T> toList(Map<String, T> tMap, IMapShow<T> mapShow) throws Exception{
        if( FrameWorkCommon.isEmpty(tMap) ) return null;
        List<T> tList = new ArrayList<>();
        for(String key : tMap.keySet()){
            if( FrameWorkCommon.isEmpty(mapShow) ){
                tList.add( tMap.get(key) );
            } else {
                mapShow.show(key, tMap.get(key));
                tList.add( tMap.get(key) );
            }
        }
        return tList;
    }

    public static <T> List<T> toListSift(Map<String, T> tMap, IMapShow<T> mapShow) throws Exception{
        if( FrameWorkCommon.isEmpty(tMap) ) return null;
        List<T> tList = new ArrayList<>();
        for(String key : tMap.keySet()){
            if( FrameWorkCommon.isEmpty( mapShow ) ){
                tList.add( tMap.get(key) );
            } else {
                try {
                    mapShow.show(key, tMap.get(key));
                    tList.add( tMap.get(key) );
                } catch (Exception e){
                    // 异常被筛选掉
                }
            }
        }
        return tList;
    }

    public static <T> void switchSift(Map<String, T> tMap, IMapSwitch<T> mapSwitch) throws Exception{
        if( FrameWorkCommon.isEmpty(tMap) ) return;
        if( FrameWorkCommon.isEmpty(mapSwitch) ) return;
        Map<String, String> switchMapKey = new HashMap<>();
        Map<String, T> switchMapValue = new HashMap<>();
        List<String> removeList = new ArrayList<>();
        String switchKey;
        for(String key : tMap.keySet()){
            try {
                switchKey = mapSwitch.switchKey( key, tMap.get(key) );
                if( FrameWorkCommon.isEmpty(switchKey) ) continue;
                if( switchKey.equals( key ) ) continue;
                switchMapKey.put(key, switchKey);
                switchMapValue.put(key, tMap.get(key));
            } catch (Exception e){
                removeList.add( key );
            }
        }
        if( FrameWorkCommon.isNotEmpty(removeList) ){
            for(String key: removeList){
                tMap.remove(key);
            }
        }
        if( FrameWorkCommon.isNotEmpty(switchMapKey) ){
            for(String key : switchMapKey.keySet()){
                tMap.remove(key);
                tMap.put( switchMapKey.get(key), switchMapValue.get(key) );
            }
        }
    }
}
