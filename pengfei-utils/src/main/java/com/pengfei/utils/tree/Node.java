package com.pengfei.utils.tree;

import com.pengfei.framework.tree.AbsTree;

public class Node extends AbsTree<Node> {

    private String id;
    private String name;
    private String parentId;

    public Node(){

    }

    public Node(String id, String name, String parentId){
        this.setId(id);
        this.setName(name);
        this.setParentId(parentId);
    }

    @Override
    protected Class getClassName() {
        return Node.class;
    }

    @Override
    protected String getId(Node treeData) {
        return treeData.getId();
    }

    @Override
    protected String getName(Node treeData) {
        return treeData.getName();
    }

    @Override
    protected String getParentId(Node treeData) {
        return treeData.getParentId();
    }

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
}
