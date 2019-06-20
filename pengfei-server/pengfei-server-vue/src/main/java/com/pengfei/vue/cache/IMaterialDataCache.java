package com.pengfei.vue.cache;


import com.pengfei.base.cache.IBaseCache;
import com.pengfei.model.material.MaterialData;

public interface IMaterialDataCache extends IBaseCache<MaterialData> {


    void deleteByMaterialType(String materialTypeId) throws Exception;
}
