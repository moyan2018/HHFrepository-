package com.pengfei.model.material;

import com.pengfei.base.bean.AbsBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "物料类型", description = "物料类型")
public class MaterialType extends AbsBean {

    @ApiModelProperty(value = "物料类型id", required = false, example = "")
    private String materialTypeId;
    @ApiModelProperty(value = "物料类型名称", required = false, example = "")
    private String materialTypeName;
    @ApiModelProperty(value = "物料类型编码", required = false, example = "")
    private String materialTypeCode;
    @ApiModelProperty(value = "状态", required = false, example = "1")
    private Integer status;
    @ApiModelProperty(value = "上级物料类型id", required = false, example = "")
    private String superMaterialTypeId;
    @ApiModelProperty(value = "是否可以添加数据", required = false, example = "1")
    private Integer canData;
    @ApiModelProperty(value = "创建人", required = false)
    private String creator;
    @ApiModelProperty(value = "创建时间", required = false)
    private Date createDate;
    @ApiModelProperty(value = "修改人", required = false)
    private String updater;
    @ApiModelProperty(value = "修改时间", required = false)
    private Date updateDate;
    private List<MaterialType> children;

    public MaterialType(String materialTypeId){
        this.materialTypeId = materialTypeId;
    }
    public MaterialType(){ }

    public String getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(String materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public String getMaterialTypeCode() {
        return materialTypeCode;
    }

    public void setMaterialTypeCode(String materialTypeCode) {
        this.materialTypeCode = materialTypeCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSuperMaterialTypeId() {
        return superMaterialTypeId;
    }

    public void setSuperMaterialTypeId(String superMaterialTypeId) {
        this.superMaterialTypeId = superMaterialTypeId;
    }

    public Integer getCanData() {
        return canData;
    }

    public void setCanData(Integer canData) {
        this.canData = canData;
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

    public List<MaterialType> getChildren() {
        return children;
    }

    public void setChildren(List<MaterialType> children) {
        this.children = children;
    }
}
