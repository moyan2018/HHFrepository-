package com.pengfei.vue.cache;


import com.pengfei.base.cache.IBaseCache;
import com.pengfei.model.material.ParamField;

import java.util.List;
import java.util.Map;

public interface IParamFieldCache extends IBaseCache<ParamField> {

    Map<String, List<ParamField>> getParamFieldMapList() throws Exception;

    /**
     * 删除对应物料类型下的所有物料数据
     * @param materialTypeId
     * @throws Exception
     */
    void deleteByMaterialType(String materialTypeId) throws Exception;

}
