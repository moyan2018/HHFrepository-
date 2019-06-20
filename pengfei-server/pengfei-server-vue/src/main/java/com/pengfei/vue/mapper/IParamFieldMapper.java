package com.pengfei.vue.mapper;


import com.pengfei.base.mapper.IBaseMapper;
import com.pengfei.model.material.ParamField;

public interface IParamFieldMapper extends IBaseMapper<ParamField> {


    int deleteByMaterialType(String materialTypeId) throws Exception;
}
