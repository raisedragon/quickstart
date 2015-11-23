package com.raise.core.mybatis;

import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;

public class Page{
    /**
     * 不进行count查询
     */
    private static final int NO_SQL_COUNT = -1;

    /**
     * 进行count查询
     */
    private static final int SQL_COUNT = 0;

    private int pageNum;
    private int pageSize;
    private int startRow;
    private int endRow;
    private long total;
    private int pages;

    public Page(int pageNum, int pageSize) {
        this(pageNum, pageSize, SQL_COUNT);
    }

    public Page(int pageNum, int pageSize, boolean count) {
        this(pageNum, pageSize, count ? Page.SQL_COUNT : Page.NO_SQL_COUNT);
    }

    public Page(int pageNum, int pageSize, int total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.startRow = pageNum > 0 ? (pageNum - 1) * pageSize : 0;
        this.endRow = pageNum * pageSize;
    }

    public Page(RowBounds rowBounds, boolean count) {
        this(rowBounds, count ? Page.SQL_COUNT : Page.NO_SQL_COUNT);
    }


    public Page(RowBounds rowBounds, int total) {
        this.pageSize = rowBounds.getLimit();
        this.startRow = rowBounds.getOffset();
        //RowBounds方式默认不求count总数，如果想求count,可以修改这里为SQL_COUNT
        this.total = total;
        this.endRow = this.startRow + this.pageSize;
    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
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

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        this.pages = (int) (total / this.pageSize + ((total % this.pageSize == 0) ? 0 : 1));
    }

    public boolean isCount() {
        return this.total > NO_SQL_COUNT;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", total=" + total +
                ", pages=" + pages +
                '}';
    }
}