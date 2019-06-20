package com.pengfei.vue.dao.impl;

import com.pengfei.base.dao.AbsBaseDao;
import com.pengfei.base.mapper.IBaseMapper;
import com.pengfei.framework.listMap.IListMapTree;
import com.pengfei.model.material.MaterialType;
import com.pengfei.utils.empty.EmptyUtils;
import com.pengfei.utils.listMap.ListMapUtils;
import com.pengfei.vue.dao.IMaterialTypeDao;
import com.pengfei.vue.mapper.IMaterialTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@CacheConfig(cacheNames = {"myCache"})
public class MaterialTypeDaoImpl extends AbsBaseDao<MaterialType> implements IMaterialTypeDao {

    @Autowired
    private IMaterialTypeMapper materialTypeMapper;

    @Override
    protected IBaseMapper<MaterialType> getBaseMapper() {
        return this.materialTypeMapper;
    }


    @Override
    @Cacheable(key = "targetClass + ':getMaterialTypeMap'")
    public Map<String, MaterialType> getMaterialTypeMap() throws Exception {
        MaterialType query = new MaterialType();
        List<MaterialType> materialTypeList = this.materialTypeMapper.queryList(query);
        if( EmptyUtils.isEmpty(materialTypeList) ) return null;
        return ListMapUtils.listMapTree(materialTypeList, new IListMapTree<MaterialType>() {
            @Override
            public String getParentKey(MaterialType tData) throws Exception {
                return tData.getSuperMaterialTypeId();
            }

            @Override
            public void setChildren(MaterialType parent, MaterialType child) throws Exception {
                if( EmptyUtils.isEmpty( parent.getChildren() ) ){
                    parent.setChildren( new ArrayList<>() );
                }
                parent.getChildren().add( child );
            }

            @Override
            public String getKey(MaterialType tData) throws Exception {
                return tData.getMaterialTypeId();
            }
        });
    }

    @Override
    public long queryByMaterialTypeCodeAndName(String materialTypeCode, String materialTypeName) {
        return this.materialTypeMapper.queryByMaterialTypeCodeAndName(materialTypeCode,materialTypeName);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(key = "targetClass + ':getMaterialTypeMap'")
    })
    public void clearCache() throws Exception {
        super.clearCache();
    }
}
