package com.pengfei.base.cache;


import com.pengfei.base.dao.IBaseDao;

import java.util.List;

public abstract class AbsBaseCache<T> extends AbsCacheClear implements IBaseCache<T> {

    protected abstract IBaseDao<T> getBaseDao();

    @Override
    public int add(T addData) throws Exception {
        return this.getBaseDao().add( addData );
    }

    @Override
    public int update(T updateData) throws Exception {
        return this.getBaseDao().update( updateData );
    }

    @Override
    public int delete(T deleteData) throws Exception {
        return this.getBaseDao().delete( deleteData );
    }

    @Override
    public long count(T countData) throws Exception {
        return this.getBaseDao().count( countData );
    }

    @Override
    public T query(T queryData) throws Exception {
        return this.getBaseDao().query( queryData );
    }

    @Override
    public List<T> queryList(T queryData) throws Exception {
        return this.getBaseDao().queryList( queryData );
    }
}
