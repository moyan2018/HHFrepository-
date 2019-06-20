package com.pengfei.base.dao;

import com.pengfei.base.cache.ICacheClear;

import java.util.List;

public interface IBaseDao<T> extends ICacheClear {

    int add(T addData) throws Exception;

    int update(T updateData) throws Exception;

    int delete(T deleteData) throws Exception;

    long count(T countData) throws Exception;

    T query(T queryData) throws Exception;

    List<T> queryList(T queryData) throws Exception;

}
