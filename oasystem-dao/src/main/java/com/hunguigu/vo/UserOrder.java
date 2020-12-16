package com.hunguigu.vo;
/**
 * 订单表
 */

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserOrder {
    private Integer id;

    private String order_number;//订单号

    private User user;//用户对象

    private User merchants;//商户对象

    @JsonFormat(pattern = "yyyy-MM-dd hh:ss:mm")
    @JSONField(format = "yyyy-MM-dd hh:ss:mm")
    private Date createtime;//订单创建时间

    @JsonFormat(pattern = "yyyy-MM-dd hh:ss:mm")
    @JSONField(format = "yyyy-MM-dd hh:ss:mm")
    private Date shipmenttime;//出库时间

    private String color;//颜色

    private String version;//版本

    private String img;//商品图片

    private Float price;/*单价*/

    private Integer number;/*数量*/

    private Commodity commodity;

    private Float totalmoney;/*总价*/

    private Integer state;//状态(0 待付款|1 (待发货|待收货)|2 待提货|3 已提货 )

    private String remark;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getMerchants() {
        return merchants;
    }

    public void setMerchants(User merchants) {
        this.merchants = merchants;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getShipmenttime() {
        return shipmenttime;
    }

    public void setShipmenttime(Date shipmenttime) {
        this.shipmenttime = shipmenttime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", order_number='" + order_number + '\'' +
                ", user=" + user +
                ", merchants=" + merchants +
                ", createtime=" + createtime +
                ", shipmenttime=" + shipmenttime +
                ", color='" + color + '\'' +
                ", version='" + version + '\'' +
                ", img='" + img + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", commodity=" + commodity +
                ", totalmoney=" + totalmoney +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                '}';
    }
}