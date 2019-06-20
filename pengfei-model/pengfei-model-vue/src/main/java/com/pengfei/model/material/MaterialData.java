package com.pengfei.model.material;

import com.pengfei.base.bean.AbsBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "物料数据", description = "物料数据")
public class MaterialData extends AbsBean {

    @ApiModelProperty(value = "物料数据id", required = false, example = "")
    private String materialDataId;
    @ApiModelProperty(value = "物料类型", required = false, example = "")
    private String materialTypeId;
    @ApiModelProperty(value = "物料json数据", required = false, example = "")
    private String dataJson;
    @ApiModelProperty(value = "序号", required = false, example = "")
    private Integer ix;
    @ApiModelProperty(value = "编码（料号）", required = false, example = "")
    private String materialCode;
    @ApiModelProperty(value = "项目编码", required = false, example = "")
    private String projectCode;
    @ApiModelProperty(value = "制造商型号", required = false, example = "")
    private String orderingCode;
    @ApiModelProperty(value = "制造商（品牌）", required = false, example = "")
    private String mfrName;
    @ApiModelProperty(value = "规格书", required = false, example = "")
    private String specification;
    @ApiModelProperty(value = "是否需要建库", required = false, example = "0")
    private Integer isBuild;
    @ApiModelProperty(value = "状态", required = false, example = "1")
    private Integer status;
    @ApiModelProperty(value = "创建人", required = false)
    private String creator;
    @ApiModelProperty(value = "创建时间", required = false)
    private Date createDate;
    @ApiModelProperty(value = "修改人", required = false)
    private String updater;
    @ApiModelProperty(value = "修改时间", required = false)
    private Date updateDate;
    private List<MaterialType> materialTypeList;

    public MaterialData(String materialDataId){
        this.materialDataId = materialDataId;
    }
    public MaterialData(){ }

    public String getMaterialDataId() {
        return materialDataId;
    }

    public void setMaterialDataId(String materialDataId) {
        this.materialDataId = materialDataId;
    }

    public String getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(String materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }

    public Integer getIx() {
        return ix;
    }

    public void setIx(Integer ix) {
        this.ix = ix;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getOrderingCode() {
        return orderingCode;
    }

    public void setOrderingCode(String orderingCode) {
        this.orderingCode = orderingCode;
    }

    public String getMfrName() {
        return mfrName;
    }

    public void setMfrName(String mfrName) {
        this.mfrName = mfrName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getIsBuild() {
        return isBuild;
    }

    public void setIsBuild(Integer isBuild) {
        this.isBuild = isBuild;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
