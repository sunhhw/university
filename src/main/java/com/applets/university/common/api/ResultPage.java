package com.applets.university.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author shw
 * @date 2020/11/29 17:00
 * 分页数据
 */
public class ResultPage<T> {

    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 分页数据
     */
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> ResultPage<T> restPage(List<T> list) {
        ResultPage<T> resultPage = new ResultPage<>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        resultPage.setPageNum(pageInfo.getPageNum());
        resultPage.setPageSize(pageInfo.getPageSize());
        resultPage.setTotal(pageInfo.getTotal());
        resultPage.setTotalPage(pageInfo.getPages());
        resultPage.setList(pageInfo.getList());
        return resultPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}