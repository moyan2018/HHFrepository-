package com.pengfei.vue.service.impl;

import com.pengfei.base.cache.IBaseCache;
import com.pengfei.base.service.AbsBaseService;
import com.pengfei.model.material.MaterialData;
import com.pengfei.vue.cache.IMaterialDataCache;
import com.pengfei.vue.service.IMaterialDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialDataServiceImpl extends AbsBaseService<MaterialData> implements IMaterialDataService {

    @Autowired
    private IMaterialDataCache materialDataCache;

    @Override
    protected IBaseCache<MaterialData> getBaseCache() {
        return this.materialDataCache;
    }

    @Override
    public void deleteByMaterialType(String materialTypeId) throws Exception {
        this.materialDataCache.deleteByMaterialType(materialTypeId);
    }

    @Override
    public void clearCache() throws Exception {
        this.materialDataCache.clearCache();
    }
}
