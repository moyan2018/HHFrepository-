package com.pengfei.vue.face.impl;

import com.pengfei.base.bean.Pager;
import com.pengfei.model.material.ParamField;
import com.pengfei.utils.empty.EmptyUtils;
import com.pengfei.vue.face.IPfkjDataFace;
import com.pengfei.vue.service.IMaterialTypeService;
import com.pengfei.vue.service.IParamFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PfkjDataFaceImpl implements IPfkjDataFace {

    @Autowired
    private IParamFieldService paramFieldService;
    @Autowired
    private IMaterialTypeService materialTypeService;

    @Override
    public Pager<ParamField> getPagerParamField(String materialTypeId, int pageNum, int pageSize) throws Exception {

        //1.根据materialTypeId查询参数字段
        ParamField temp = new ParamField();
        if(EmptyUtils.isNotEmpty(materialTypeId)){
            //2.插入父类物料类型的id
            temp.setMaterialTypeList( this.materialTypeService.getParents(materialTypeId, true) );
            //3.进行查询
            return this.paramFieldService.queryPage(temp, pageNum, pageSize);
        }
        return this.paramFieldService.queryPage(temp, pageNum, pageSize);
    }
}
