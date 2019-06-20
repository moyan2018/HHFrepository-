package com.pengfei.framework.listMap;

public interface IListMapTree<T> extends IListToMap<T> {

    String getParentKey(T tData) throws Exception;

    void setChildren(T parent, T child) throws Exception;
}
