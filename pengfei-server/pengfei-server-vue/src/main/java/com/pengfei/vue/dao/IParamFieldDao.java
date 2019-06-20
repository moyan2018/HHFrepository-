package com.pengfei.vue.dao;


import com.pengfei.base.dao.IBaseDao;
import com.pengfei.model.material.ParamField;

import java.util.List;
import java.util.Map;

public interface IParamFieldDao extends IBaseDao<ParamField> {

    Map<String, List<ParamField>> getParamFieldMapList() throws Exception;

    int deleteByMaterialType(String materialTypeId) throws Exception;
}
