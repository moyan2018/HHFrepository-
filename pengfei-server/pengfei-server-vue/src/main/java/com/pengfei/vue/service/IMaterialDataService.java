package com.pengfei.vue.service;


import com.pengfei.base.service.IBaseService;
import com.pengfei.model.material.MaterialData;

public interface IMaterialDataService extends IBaseService<MaterialData> {


    void deleteByMaterialType(String materialTypeId) throws Exception;
}
