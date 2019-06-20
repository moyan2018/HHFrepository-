package com.pengfei.base.mapper;

import java.util.List;

public interface IBaseMapper<T> {

    int add(T addData) throws Exception;

    int update(T updateData) throws Exception;

    int delete(T deleteData) throws Exception;

    long count(T countData) throws Exception;

    T query(T queryData) throws Exception;

    List<T> queryList(T queryData) throws Exception;

}
