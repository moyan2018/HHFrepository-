package com.pengfei.vue.controller;

import com.pengfei.base.bean.Pager;
import com.pengfei.base.bean.ReturnResult;
import com.pengfei.model.material.ParamField;
import com.pengfei.vue.face.IPfkjDataFace;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pfkjWeb")
public class PfkjDataController {

    @Autowired
    private IPfkjDataFace pfkjDataFace;

    @ApiOperation(value = "查询参数字段", notes = "查询参数字段")
    @RequestMapping(value = "findAllParamField", method = RequestMethod.GET)
    public ReturnResult<Pager<ParamField>> getPagerParamField(
            @RequestParam(value = "materialTypeId") String materialTypeId,
            @RequestParam(value = "pageNum") int pageNum,
            @RequestParam(value = "pageSize") int pageSize) throws Exception{
        Pager<ParamField> pager = this.pfkjDataFace.getPagerParamField(materialTypeId,pageNum, pageSize);
        return ReturnResult.Success(pager);
    }
}
