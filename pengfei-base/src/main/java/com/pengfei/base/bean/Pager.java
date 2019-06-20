package com.pengfei.base.bean;

import com.github.pagehelper.Page;

import java.util.List;

public class Pager<T> {

    private int pageNum;
    private int pageSize;
    private long total;
    private int pageTotal;
    private List<T> data;

    public Pager(Page<T> page){
        this.setPageNum( page.getPageNum() );
        this.setPageSize( page.getPageSize() );
        this.setPageTotal( page.getPages() );
        this.setTotal( page.getTotal() );
        this.setData( page.getResult() );
    }

    public Pager(){

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
