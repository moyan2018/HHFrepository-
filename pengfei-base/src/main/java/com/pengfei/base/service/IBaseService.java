package com.pengfei.base.service;

import com.pengfei.base.bean.Pager;
import com.pengfei.base.cache.ICacheClear;

import java.util.List;

public interface IBaseService<T> extends ICacheClear {

    boolean add(T addData) throws Exception;

    boolean update(T updateData) throws Exception;

    boolean delete(T deleteData) throws Exception;

    long count(T countData) throws Exception;

    T query(T queryData) throws Exception;

    List<T> queryList(T queryData) throws Exception;

    Pager<T> queryPage(T queryData, int pageNum, int pageSize) throws Exception;
}
