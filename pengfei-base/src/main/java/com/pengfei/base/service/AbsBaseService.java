package com.pengfei.base.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pengfei.base.bean.Pager;
import com.pengfei.base.cache.AbsCacheClear;
import com.pengfei.base.cache.IBaseCache;

import java.util.List;

public abstract class AbsBaseService<T> extends AbsCacheClear implements IBaseService<T> {

    protected abstract IBaseCache<T> getBaseCache();

    @Override
    public boolean add(T addData) throws Exception {
        int result = this.getBaseCache().add( addData );
        if( result == 0 ){
            throw new Exception("新增操作失败");
        }
        return true;
    }

    @Override
    public boolean update(T updateData) throws Exception {
        int result = this.getBaseCache().update( updateData );
        if( result == 0 ){
            throw new Exception("修改操作失败");
        }
        return true;
    }

    @Override
    public boolean delete(T deleteData) throws Exception {
        int result = this.getBaseCache().delete( deleteData );
        if( result == 0 ){
            throw new Exception("删除操作失败");
        }
        return true;
    }

    @Override
    public long count(T countData) throws Exception {
        return this.getBaseCache().count( countData );
    }

    @Override
    public T query(T queryData) throws Exception {
        return this.getBaseCache().query( queryData );
    }

    @Override
    public List<T> queryList(T queryData) throws Exception {
        return this.getBaseCache().queryList( queryData );
    }

    @Override
    public Pager<T> queryPage(T queryData, int pageNum, int pageSize) throws Exception {
        Page<T> page = PageHelper.startPage(pageNum, pageSize);
        this.getBaseCache().queryList( queryData );
        return new Pager<>( page );
    }
}
