package com.pengfei.utils.tree;

import com.pengfei.framework.exception.AbsBaseException;
import com.pengfei.framework.tree.TreeBean;
import com.pengfei.framework.tree.TreeManager;

import java.util.List;

public final class TreeUtils {

    private TreeUtils(){

    }

    public static <T> List<TreeBean<T>> tree(List<T> listData) throws AbsBaseException {
        return TreeManager.tree(listData);
    }

}
