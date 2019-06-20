package com.pengfei.vue.face;

import com.pengfei.base.bean.Pager;
import com.pengfei.model.material.ParamField;

public interface IPfkjDataFace {

    /**
     * 查询所有的参数字段
     */
    Pager<ParamField> getPagerParamField(String materialTypeId, int pageNum, int pageSize) throws  Exception;
}
