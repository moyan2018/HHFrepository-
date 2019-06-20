package com.pengfei.vue.cache.impl;

import com.pengfei.base.cache.AbsBaseCache;
import com.pengfei.base.dao.IBaseDao;
import com.pengfei.model.material.ParamField;
import com.pengfei.vue.cache.IParamFieldCache;
import com.pengfei.vue.dao.IParamFieldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ParamFieldCacheImpl extends AbsBaseCache<ParamField> implements IParamFieldCache {

    @Autowired
    private IParamFieldDao paramFieldDao;

    @Override
    protected IBaseDao<ParamField> getBaseDao() {
        return this.paramFieldDao;
    }

    @Override
    public Map<String, List<ParamField>> getParamFieldMapList() throws Exception {
        return this.paramFieldDao.getParamFieldMapList();
    }

    @Override
    public void deleteByMaterialType(String materialTypeId) throws Exception {
        this.paramFieldDao.deleteByMaterialType(materialTypeId);
    }

    @Override
    public void clearCache() throws Exception {
        this.paramFieldDao.clearCache();
    }
}
