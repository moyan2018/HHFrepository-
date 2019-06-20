package com.pengfei.vue.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.pengfei.base.cache.IBaseCache;
import com.pengfei.base.service.AbsBaseService;
import com.pengfei.model.material.ParamField;
import com.pengfei.utils.json.JsonUtils;
import com.pengfei.vue.cache.IParamFieldCache;
import com.pengfei.vue.service.IParamFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ParamFieldServiceImpl extends AbsBaseService<ParamField> implements IParamFieldService {

    @Autowired
    private IParamFieldCache paramFieldCache;

    @Override
    protected IBaseCache<ParamField> getBaseCache() {
        return this.paramFieldCache;
    }

    @Override
    public Map<String, List<ParamField>> getParamFieldMapList() throws Exception {
        return JSONObject.parseObject(JsonUtils.toJson(this.paramFieldCache.getParamFieldMapList()), new TypeReference<Map<String, List<ParamField>>>() {});
    }

    @Override
    public void deleteByMaterialType(String materialTypeId) throws Exception {
        this.paramFieldCache.deleteByMaterialType(materialTypeId);
    }

    @Override
    public void clearCache() throws Exception {
        this.paramFieldCache.clearCache();
    }
}
