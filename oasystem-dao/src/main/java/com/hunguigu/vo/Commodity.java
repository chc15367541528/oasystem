package com.hunguigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.servlet.annotation.HandlesTypes;
import java.util.List;

/**
 * 商品表
 */
@JsonIgnoreProperties(value = { "handler" })
public class Commodity {
    private Integer id;

    private String name;//商品名字

    private String specifications;//商品规格

    private CommodityType commodityType;//商品类别对象

    private Brand brand;//商品品牌对象

    private String img;//商品图片

    private String remark;//备注

    private String minPrice;//查询商品使用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public CommodityType getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(CommodityType commodityType) {
        this.commodityType = commodityType;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }
}