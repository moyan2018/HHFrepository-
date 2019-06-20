package com.pengfei.framework.tree;

import javax.annotation.PostConstruct;

public abstract class AbsTree<T> {

    // 获取树形对象类型
    protected abstract Class getClassName();
    // 获取树形id
    protected abstract String getId(T treeData);
    // 获取树形name
    protected abstract String getName(T treeData);
    // 获取上级树形id
    protected abstract String getParentId(T treeData);

    @PostConstruct
    public void init(){
        // 加入树形定义
        TreeManager.define( this.getClassName(), this );
    }
}
