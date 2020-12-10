package com.hunguigu.vo;

/**
 * 商品表
 */
public class Commodity {
    private Integer id;

    private String name;//商品名字

    private String specifications;//商品规格

    private CommodityType commodityType;//商品类别对象

    private Brand brand;//商品品牌对象

    private String remark;//备注

    public Commodity() {
    }

    public Commodity(Integer id, String name, String specifications, CommodityType commodityType, Brand brand, String remark) {
        this.id = id;
        this.name = name;
        this.specifications = specifications;
        this.commodityType = commodityType;
        this.brand = brand;
        this.remark = remark;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}