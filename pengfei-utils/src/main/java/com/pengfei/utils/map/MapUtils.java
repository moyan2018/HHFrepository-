package com.pengfei.utils.map;

import com.pengfei.framework.map.IMapShow;
import com.pengfei.framework.map.IMapSwitch;
import com.pengfei.framework.map.MapManager;

import java.util.List;
import java.util.Map;

public final class MapUtils {

    private MapUtils(){

    }

    public static <T> void show(Map<String, T> tMap, IMapShow<T> mapShow) throws Exception{
        MapManager.show(tMap, mapShow);
    }

    public static <T> void showSift(Map<String, T> tMap, IMapShow<T> mapShow) throws Exception{
        MapManager.showSift(tMap, mapShow);
    }

    public static <T> List<T> toList(Map<String, T> tMap, IMapShow<T> mapShow) throws Exception{
        return MapManager.toList(tMap, mapShow);
    }

    public static <T> List<T> toListSift(Map<String, T> tMap, IMapShow<T> mapShow) throws Exception{
        return MapManager.toListSift(tMap, mapShow);
    }

    public static <T> void switchSift(Map<String, T> tMap, IMapSwitch<T> mapSwitch) throws Exception{
        MapManager.switchSift(tMap, mapSwitch);
    }

}
