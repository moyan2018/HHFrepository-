package com.pengfei.framework.list;

import java.util.List;

public interface IListAccretion<T> {


    List<String> accretionList(T tData) throws Exception;

    List<T> accretion(List<String> tList, T tData) throws Exception;

}
