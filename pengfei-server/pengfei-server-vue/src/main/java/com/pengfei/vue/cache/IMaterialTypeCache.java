package com.pengfei.vue.cache;


import com.pengfei.base.cache.IBaseCache;
import com.pengfei.model.material.MaterialType;

import java.util.List;
import java.util.Map;

public interface IMaterialTypeCache extends IBaseCache<MaterialType> {

    /**
     * 查询指定物料类型的所有父类
     * @param materialTypeId
     * @return
     * @throws Exception
     */
    List<MaterialType> getParents(String materialTypeId, boolean isContainSelf) throws Exception;

    /**
     * 查询指定物料类型的所有子类
     * @param materialTypeId
     * @return
     * @throws Exception
     */
    List<MaterialType> getChildren(String materialTypeId, boolean isContainSelf) throws Exception;

    /**
     * 通过编码，名称查询是否有重复
     * @param materialTypeCode
     * @return
     */
    long queryByMaterialTypeCodeAndName(String materialTypeCode, String materialTypeName);
    /**
     * 查询物料类型map，并且将子类父类关联
     * @return
     * @throws Exception
     */
    Map<String, MaterialType> getMaterialTypeMap() throws Exception;
}
