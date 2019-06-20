package com.pengfei.vue.mapper;

import com.pengfei.base.mapper.IBaseMapper;
import com.pengfei.model.material.MaterialType;
import org.apache.ibatis.annotations.Param;

public interface IMaterialTypeMapper extends IBaseMapper<MaterialType> {

    long queryByMaterialTypeCodeAndName(@Param("materialTypeCode") String materialTypeCode, @Param("materialTypeName") String materialTypeName);
}
