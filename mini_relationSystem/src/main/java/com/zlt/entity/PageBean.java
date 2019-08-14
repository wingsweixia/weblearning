/**
 * @Description: java类作用描述
 * @Author: weixia
 * @CreateDate: 2019/8/12$ 16:47$
 * @UpdateUser: yc
 * @UpdateDate: 2019/8/12$ 16:47$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
package com.zlt.entity;

import java.util.List;

public class PageBean<T> {
    private List<T> list;
    private int pageNum;//当前页
    private int pageSize;//每页记录条数
    private int totalRecord;//总记录数
    private int totalPage;
    private int startIndex;//每页数据起始索引
    private int start;//首页
    private int end;//末页

    public PageBean(){

    }

    public PageBean(int pageNum,int pageSize,int totalRecord){
        this.pageNum=pageNum;
        this.totalRecord=totalRecord;
        this.pageSize=pageSize;
        this.totalPage=this.totalRecord%this.pageSize==0?this.totalRecord/this.pageSize:this.totalRecord/this.pageSize+1;
        this.startIndex=(pageNum-1)*pageSize;
        this.start=1;
        this.end=5;
        if(totalPage<=5)
            this.end=this.totalPage;
        else
        {
            this.start=pageNum-2;
            this.end=pageNum+2;
            if(this.start<0) {
                this.start = 1;
                this.end=5;
            }
            if(this.end>5){
                this.end=this.totalPage;
                this.start=this.totalPage-5;
            }
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
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

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
