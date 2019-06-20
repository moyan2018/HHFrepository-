package com.pengfei.vue.service;


import com.pengfei.base.service.IBaseService;
import com.pengfei.model.material.ParamField;

import java.util.List;
import java.util.Map;

public interface IParamFieldService extends IBaseService<ParamField> {

    Map<String, List<ParamField>> getParamFieldMapList() throws Exception;

    /**
     * 删除对应物料类型下的所有物料数据
     * @param materialTypeId
     * @throws Exception
     */
    void deleteByMaterialType(String materialTypeId) throws Exception;

}
