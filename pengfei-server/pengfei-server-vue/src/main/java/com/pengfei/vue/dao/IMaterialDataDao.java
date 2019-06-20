package com.pengfei.vue.dao;


import com.pengfei.base.dao.IBaseDao;
import com.pengfei.model.material.MaterialData;

public interface IMaterialDataDao extends IBaseDao<MaterialData> {

    int deleteByMaterialType(String materialTypeId) throws Exception;
}
