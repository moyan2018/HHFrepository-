package com.pengfei.framework.map;

public interface IMapSwitch<T> {

    String switchKey(String key, T tData) throws Exception;

}
