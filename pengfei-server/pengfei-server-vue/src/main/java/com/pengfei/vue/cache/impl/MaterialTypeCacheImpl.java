package com.pengfei.vue.cache.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.pengfei.base.cache.AbsBaseCache;
import com.pengfei.base.dao.IBaseDao;
import com.pengfei.model.material.MaterialType;
import com.pengfei.utils.empty.EmptyUtils;
import com.pengfei.utils.json.JsonUtils;
import com.pengfei.vue.cache.IMaterialTypeCache;
import com.pengfei.vue.dao.IMaterialTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MaterialTypeCacheImpl extends AbsBaseCache<MaterialType> implements IMaterialTypeCache {

    @Autowired
    private IMaterialTypeDao materialTypeDao;

    @Override
    protected IBaseDao<MaterialType> getBaseDao() {
        return this.materialTypeDao;
    }

    @Override
    public long queryByMaterialTypeCodeAndName(String materialTypeCode,String materialTypeName) {
        return this.materialTypeDao.queryByMaterialTypeCodeAndName(materialTypeCode,materialTypeName);
    }

    @Override
    public List<MaterialType> getParents(String materialTypeId, boolean isContainSelf) throws Exception {
        Map<String, MaterialType>  materialTypeMap = JSONObject.parseObject(JsonUtils.toJson(this.materialTypeDao.getMaterialTypeMap()), new TypeReference<Map<String, MaterialType>>() {});
        List<MaterialType> materialTypeList = new ArrayList<>();
        MaterialType materialType =  materialTypeMap.get(materialTypeId);
        if( EmptyUtils.isEmpty(materialType) ) return materialTypeList;
        if( isContainSelf ){
            materialTypeList.add( materialType );
        }
        MaterialType materialTypeParent;
        do{
            materialTypeParent = materialTypeMap.get( materialType.getSuperMaterialTypeId() );
            if( EmptyUtils.isEmpty(materialTypeParent) ) break;
            materialTypeList.add( materialTypeParent );
            materialType = materialTypeParent;
        } while(true);
        return materialTypeList;
    }

    @Override
    public List<MaterialType> getChildren(String materialTypeId, boolean isContainSelf) throws Exception {
        Map<String, MaterialType>  materialTypeMap = JSONObject.parseObject(JsonUtils.toJson(this.materialTypeDao.getMaterialTypeMap()), new TypeReference<Map<String, MaterialType>>() {});
        List<MaterialType> materialTypeList = new ArrayList<>();
        MaterialType materialType =  materialTypeMap.get(materialTypeId);
        if( EmptyUtils.isEmpty(materialType) ) return materialTypeList;
        if( isContainSelf ){
            materialTypeList.add( materialType );
        }
        if( EmptyUtils.isNotEmpty(materialType.getChildren()) ){
            for( MaterialType child : materialType.getChildren() ){
               this.addChildren(child, materialTypeList);
            }
        }
        return materialTypeList;
    }

    private void addChildren(MaterialType materialType, List<MaterialType> materialTypeList) throws Exception{
        materialTypeList.add( materialType );
        if( EmptyUtils.isNotEmpty(materialType.getChildren()) ){
            for( MaterialType child : materialType.getChildren() ){
                this.addChildren(child, materialTypeList);
            }
        }
    }

    @Override
    public Map<String, MaterialType> getMaterialTypeMap() throws Exception {
        return JSONObject.parseObject(JsonUtils.toJson(this.materialTypeDao.getMaterialTypeMap()), new TypeReference<Map<String, MaterialType>>() {});
    }

    @Override
    public void clearCache() throws Exception {
        this.materialTypeDao.clearCache();
    }
}
