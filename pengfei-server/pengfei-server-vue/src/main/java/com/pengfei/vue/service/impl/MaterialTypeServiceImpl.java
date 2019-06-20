package com.pengfei.vue.service.impl;

import com.pengfei.base.cache.IBaseCache;
import com.pengfei.base.service.AbsBaseService;
import com.pengfei.model.material.MaterialType;
import com.pengfei.vue.cache.IMaterialTypeCache;
import com.pengfei.vue.service.IMaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MaterialTypeServiceImpl extends AbsBaseService<MaterialType> implements IMaterialTypeService {

    @Autowired
    private IMaterialTypeCache materialTypeCache;

    @Override
    protected IBaseCache<MaterialType> getBaseCache() {
        return this.materialTypeCache;
    }

    @Override
    public long queryByMaterialTypeCodeAndName(String materialTypeCode,String materialTypeName) {
        return this.materialTypeCache.queryByMaterialTypeCodeAndName(materialTypeCode,materialTypeName);
    }

    @Override
    public List<MaterialType> getParents(String materialTypeId, boolean isContainSelf) throws Exception {
        return this.materialTypeCache.getParents(materialTypeId, isContainSelf);
    }

    @Override
    public List<MaterialType> getChildren(String materialTypeId, boolean isContainSelf) throws Exception {
        return this.materialTypeCache.getChildren(materialTypeId, isContainSelf);
    }

    @Override
    public Map<String, MaterialType> getMaterialTypeMap() throws Exception {
        return this.materialTypeCache.getMaterialTypeMap();
    }

    @Override
    public void clearCache() throws Exception {
        this.materialTypeCache.clearCache();
    }
}
