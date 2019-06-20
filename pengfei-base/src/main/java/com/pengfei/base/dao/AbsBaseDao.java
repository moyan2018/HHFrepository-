package com.pengfei.base.dao;

import com.pengfei.base.cache.AbsCacheClear;
import com.pengfei.base.mapper.IBaseMapper;

import java.util.List;

public abstract class AbsBaseDao<T> extends AbsCacheClear implements IBaseDao<T> {

    protected abstract IBaseMapper<T> getBaseMapper();

    @Override
    public int add(T addData) throws Exception {
        return this.getBaseMapper().add( addData );
    }

    @Override
    public int update(T updateData) throws Exception {
        return this.getBaseMapper().update( updateData );
    }

    @Override
    public int delete(T deleteData) throws Exception {
        return this.getBaseMapper().delete( deleteData );
    }

    @Override
    public long count(T countData) throws Exception {
        return this.getBaseMapper().count( countData );
    }

    @Override
    public T query(T queryData) throws Exception {
        return this.getBaseMapper().query( queryData );
    }

    @Override
    public List<T> queryList(T queryData) throws Exception {
        return this.getBaseMapper().queryList( queryData );
    }
}
