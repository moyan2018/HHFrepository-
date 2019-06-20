package com.pengfei.framework.tree;

import com.pengfei.framework.FrameWorkCommon;
import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.exception.TreeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TreeManager {

    private static Map<Class, AbsTree> treeMap = new HashMap<>();

    private TreeManager(){

    }

    static <T> void define(Class className, AbsTree<T> tree) {
        if( FrameWorkCommon.isEmpty(tree) || FrameWorkCommon.isEmpty(className) ) return;
        treeMap.put( className, tree );
    }

    public static <T> List<TreeBean<T>> tree(List<T> listData) throws AbsBaseException {
        try {
            if( FrameWorkCommon.isEmpty(listData) ) return null;
            T treeData = listData.get(0);
            AbsTree<T> tree = treeMap.get( treeData.getClass() );
            if( tree == null ) throw new TreeException( String.format( "%s树形配置(需要继承%s)没有！", treeData.getClass(), AbsTree.class) );
            // 转化为树形map
            Map<String, TreeBean<T>> treeBeanMap = listToTreeBeanMap(listData, tree);
            if( FrameWorkCommon.isEmpty(treeBeanMap) ) return null;
            // 父子类连接并获取根节点列表
            List<TreeBean<T>> treeBeanList = getParentAndRootNodes(treeBeanMap);
            return treeBeanList;
        } catch (Exception e){
            handleException(e);
            return null;
        }
    }

    /**
     *  转化为树形map
     * @param listData
     * @param tree
     * @param <T>
     * @return
     * @throws Exception
     */
    private static <T> Map<String, TreeBean<T>> listToTreeBeanMap(List<T> listData, AbsTree<T> tree) throws Exception{
        Map<String, TreeBean<T>> treeBeanMap = new HashMap<>();
        String id, name, parentId;
        TreeBean<T> treeBean;
        for(T data: listData){
            id = tree.getId(data);
            // 树形id为空，这个节点将被移除掉
            if( FrameWorkCommon.isEmpty(id) ) continue;
            name = tree.getName(data);
            parentId = tree.getParentId(data);
            treeBean = new TreeBean<>();
            treeBean.setId(id);
            treeBean.setName(name);
            treeBean.setParentId(parentId);
            treeBean.setData(data);
            treeBeanMap.put(id, treeBean);
        }
        return treeBeanMap;
    }

    private static <T> List<TreeBean<T>> getParentAndRootNodes(Map<String, TreeBean<T>> treeBeanMap ) throws Exception {
        TreeBean<T> treeBean, parentTreeBean;
        String parentId;
        List<TreeBean<T>> treeBeanList = new ArrayList<>();
        for(String key : treeBeanMap.keySet()){
            treeBean = treeBeanMap.get(key);
            parentId = treeBean.getParentId();
            if( FrameWorkCommon.isEmpty(parentId) ){
                treeBeanList.add( treeBean );
                continue;
            }
            if( treeBeanMap.containsKey(parentId) ){
                parentTreeBean = treeBeanMap.get(parentId);
                // 查询父类子类列表是否被实例
                if( parentTreeBean.getChildren() == null ){
                    parentTreeBean.setChildren(new ArrayList<>());
                }
                // 添加到子类列表中
                parentTreeBean.getChildren().add( treeBean );
            } else {
                treeBeanList.add( treeBean );
                continue;
            }
        }
        return treeBeanList;
    }

    static void handleException(Exception exception) throws AbsBaseException {
        if( exception instanceof AbsBaseException){
            throw (AbsBaseException) exception;
        } else {
            throw new TreeException(exception);
        }
    }

}
