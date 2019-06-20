package com.pengfei.base.cache;

public abstract class AbsCacheClear implements ICacheClear {

    @Override
    public void clearCache() throws Exception {
        System.out.println(String.format("########### clear com.pengfei.base.cache [%s] ###########", this.getClass().getName()));
    }
}
