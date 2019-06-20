package com.pengfei.model.material;

import com.pengfei.base.bean.AbsBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "参数字段", description = "参数字段")
public class ParamField extends AbsBean {

    @ApiModelProperty(value = "参数字段id", required = false, example = "")
    private String paramFieldId;
    @ApiModelProperty(value = "物料类型id 可以为空，如果为空，那么就是全部类型有效", required = false, example = "")
    private String materialTypeId;
    @ApiModelProperty(value = "参数字段编码", required = false, example = "")
    private String paramFieldCode;
    @ApiModelProperty(value = "参数字段名称", required = false, example = "")
    private String paramFieldName;
    @ApiModelProperty(value = "参数字段描述", required = false, example = "")
    private String paramFieldDesc;
    @ApiModelProperty(value = "是否必须", required = false, example = "1")
    private Integer isRequire;
    @ApiModelProperty(value = "状态", required = false, example = "1")
    private Integer status;
    @ApiModelProperty(value = "参数字段数据类型", required = false, example = "Int,Number,String")
    private String paramDataType;
    @ApiModelProperty(value = "参数字段前缀枚举值", required = false, example = "1:true；0:false")
    private String paramPrefixEnums;
    @ApiModelProperty(value = "参数字段后缀枚举值", required = false, example = "1:true；0:false")
    private String paramSuffixEnums;
    @ApiModelProperty(value = "排序", required = false, example = "1")
    private Integer ix;
    @ApiModelProperty(value = "创建人", required = false)
    private String creator;
    @ApiModelProperty(value = "创建时间", required = false)
    private Date createDate;
    @ApiModelProperty(value = "修改人", required = false)
    private String updater;
    @ApiModelProperty(value = "修改时间", required = false)
    private Date updateDate;
    private List<MaterialType> materialTypeList;

    public ParamField(String paramFieldId){
        this.paramFieldId = paramFieldId;
    }
    public ParamField(String materialTypeId,String paramFieldCode){
        this.materialTypeId = materialTypeId;
        this.paramFieldCode = paramFieldCode;
    }
    public ParamField(){ }

    public String getParamFieldId() {
        return paramFieldId;
    }

    public void setParamFieldId(String paramFieldId) {
        this.paramFieldId = paramFieldId;
    }

    public String getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(String materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getParamFieldCode() {
        return paramFieldCode;
    }

    public void setParamFieldCode(String paramFieldCode) {
        this.paramFieldCode = paramFieldCode;
    }

    public String getParamFieldName() {
        return paramFieldName;
    }

    public void setParamFieldName(String paramFieldName) {
        this.paramFieldName = paramFieldName;
    }

    public String getParamFieldDesc() {
        return paramFieldDesc;
    }

    public void setParamFieldDesc(String paramFieldDesc) {
        this.paramFieldDesc = paramFieldDesc;
    }

    public Integer getIsRequire() {
        return isRequire;
    }

    public void setIsRequire(Integer isRequire) {
        this.isRequire = isRequire;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParamDataType() {
        return paramDataType;
    }

    public void setParamDataType(String paramDataType) {
        this.paramDataType = paramDataType;
    }

    public String getParamPrefixEnums() {
        return paramPrefixEnums;
    }

    public void setParamPrefixEnums(String paramPrefixEnums) {
        this.paramPrefixEnums = paramPrefixEnums;
    }

    public String getParamSuffixEnums() {
        return paramSuffixEnums;
    }

    public void setParamSuffixEnums(String paramSuffixEnums) {
        this.paramSuffixEnums = paramSuffixEnums;
    }

    public Integer getIx() {
        return ix;
    }

    public void setIx(Integer ix) {
        this.ix = ix;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<MaterialType> getMaterialTypeList() {
        return materialTypeList;
    }

    public void setMaterialTypeList(List<MaterialType> materialTypeList) {
        this.materialTypeList = materialTypeList;
    }
}
