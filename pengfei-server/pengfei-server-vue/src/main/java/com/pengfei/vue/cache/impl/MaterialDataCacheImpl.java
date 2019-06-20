package com.pengfei.vue.cache.impl;

import com.pengfei.base.cache.AbsBaseCache;
import com.pengfei.base.dao.IBaseDao;
import com.pengfei.model.material.MaterialData;
import com.pengfei.vue.cache.IMaterialDataCache;
import com.pengfei.vue.dao.IMaterialDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MaterialDataCacheImpl extends AbsBaseCache<MaterialData> implements IMaterialDataCache {

    @Autowired
    private IMaterialDataDao materialDataDao;

    @Override
    protected IBaseDao<MaterialData> getBaseDao() {
        return this.materialDataDao;
    }

    @Override
    public void deleteByMaterialType(String materialTypeId) throws Exception {
        this.materialDataDao.deleteByMaterialType(materialTypeId);
    }

    @Override
    public void clearCache() throws Exception {
        this.materialDataDao.clearCache();
    }
}
