package com.hunguigu.vo;

import java.util.List;

public class PageVo<T> {
    private List<T> rows;

    private int total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public PageVo(List<T> rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public PageVo() {
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
