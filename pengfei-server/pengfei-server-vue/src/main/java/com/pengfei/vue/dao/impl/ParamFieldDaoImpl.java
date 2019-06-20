package com.pengfei.vue.dao.impl;

import com.pengfei.base.dao.AbsBaseDao;
import com.pengfei.base.mapper.IBaseMapper;
import com.pengfei.framework.listMap.IListToMap;
import com.pengfei.model.material.ParamField;
import com.pengfei.utils.listMap.ListMapUtils;
import com.pengfei.vue.dao.IParamFieldDao;
import com.pengfei.vue.mapper.IParamFieldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@CacheConfig(cacheNames = {"myCache"})
public class ParamFieldDaoImpl extends AbsBaseDao<ParamField> implements IParamFieldDao {

    @Autowired
    private IParamFieldMapper paramFieldMapper;

    @Override
    protected IBaseMapper<ParamField> getBaseMapper() {
        return this.paramFieldMapper;
    }

    @Override
    @Cacheable(key = "targetClass + ':getParamFieldMapList'")
    public Map<String, List<ParamField>> getParamFieldMapList() throws Exception {
        ParamField query = new ParamField();
        List<ParamField> paramFieldList = this.paramFieldMapper.queryList(query);
        return ListMapUtils.listToMapList(paramFieldList, new IListToMap<ParamField>() {
            @Override
            public String getKey(ParamField tData) throws Exception {
                return tData.getMaterialTypeId();
            }
        });
    }

    @Override
    public int deleteByMaterialType(String materialTypeId) throws Exception {
        return this.paramFieldMapper.deleteByMaterialType(materialTypeId);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(key = "targetClass + ':getParamFieldMapList'")
    })
    public void clearCache() throws Exception {
        super.clearCache();
    }
}
