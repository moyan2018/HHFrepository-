package com.pengfei.vue.dao;

import com.pengfei.base.dao.IBaseDao;
import com.pengfei.model.material.MaterialType;

import java.util.Map;

public interface IMaterialTypeDao extends IBaseDao<MaterialType> {

    Map<String, MaterialType> getMaterialTypeMap() throws Exception;

    long queryByMaterialTypeCodeAndName(String materialTypeCode, String materialTypeName);
}
