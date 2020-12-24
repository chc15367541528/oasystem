package com.hunguigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "handler" })
public class ColorInfo {
    private Integer id;
    private Commodity commodity;/*商品*/
    private String color;/*颜色*/
    private String remark;

    public ColorInfo() {
    }

    public ColorInfo(Integer id, Commodity commodity, String color, String remark) {
        this.id = id;
        this.commodity = commodity;
        this.color = color;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
