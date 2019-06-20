package com.pengfei.vue.mapper;


import com.pengfei.base.mapper.IBaseMapper;
import com.pengfei.model.material.MaterialData;

public interface IMaterialDataMapper extends IBaseMapper<MaterialData> {

    int delteByMaterialType(String materialTypeId) throws Exception;
}
