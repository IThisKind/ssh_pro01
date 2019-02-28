package com.oracle.service;

import java.util.List;

/**
 * @Description: 分页类
 * @Author: 牛
 * @CreateDate: 2019/2/25 00:20
 * @UpdateUser: 牛
 * @UpdateDate: 2019/2/25 00:20
 * @UpdateRemark:
 * @Version: 1.0
 **/
public class Page<T> {
    //属性
    private int pageSize = 5;  //每页显示的记录数
    private int totalPageCount = 1;  //总页数
    private int totalCount = 0;   //总记录数
    private int currPageNo = 1;   //当前页
    private List<T> data;  //每页显示的数据

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 总记录数
     *
     * @param totalCount
     */
    @SuppressWarnings("all")
    public void setTotalCount(int totalCount) {
        if (totalCount > 0)
            this.totalCount = totalCount;

        //在得到总计录数的同时，计算一下总页数
        this.totalPageCount = this.totalCount % this.pageSize == 0 ? (this.totalCount / this.pageSize) : (this.totalCount / this.pageSize + 1);
    }

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
