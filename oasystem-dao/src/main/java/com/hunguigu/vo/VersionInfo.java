package com.hunguigu.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "handler" })
public class VersionInfo {
    private Integer id;
    private Commodity commodity;/*商品*/
    private String version;/*版本*/
    private Float price;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "VersionInfo{" +
                "id=" + id +
                ", commodity=" + commodity +
                ", version='" + version + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
