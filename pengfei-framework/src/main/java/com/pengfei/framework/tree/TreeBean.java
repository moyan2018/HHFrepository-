package com.pengfei.framework.tree;

import java.util.List;

public class TreeBean<T> {

    private String id;
    private String name;
    private String parentId;
    private List<TreeBean<T>> children;
    private T data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TreeBean<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeBean<T>> children) {
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
