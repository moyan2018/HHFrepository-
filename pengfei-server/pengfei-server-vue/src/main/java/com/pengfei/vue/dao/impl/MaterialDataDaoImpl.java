package com.pengfei.vue.dao.impl;

import com.pengfei.base.dao.AbsBaseDao;
import com.pengfei.base.mapper.IBaseMapper;
import com.pengfei.model.material.MaterialData;
import com.pengfei.vue.dao.IMaterialDataDao;
import com.pengfei.vue.mapper.IMaterialDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MaterialDataDaoImpl extends AbsBaseDao<MaterialData> implements IMaterialDataDao {

    @Autowired
    private IMaterialDataMapper materialDataMapper;

    @Override
    protected IBaseMapper<MaterialData> getBaseMapper() {
        return this.materialDataMapper;
    }

    @Override
    public int deleteByMaterialType(String materialTypeId) throws Exception {
        return this.materialDataMapper.delteByMaterialType(materialTypeId);
    }

    @Override
    public void clearCache() throws Exception {

    }
}
