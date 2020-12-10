package com.hunguigu.vo;

/**
 * 购物车信息表
 */
public class ShoppingCart {
    private Integer id;

    private User user;//用户信息

    private Commodity commodity;//商品对象

    private ColorInfo colorInfo;/*商品颜色*/

    private Integer number;//商品件数

    private String remark;//备注

    public ShoppingCart() {
    }

    public ShoppingCart(Integer id, User user, Commodity commodity, ColorInfo colorInfo, Integer number, String remark) {
        this.id = id;
        this.user = user;
        this.commodity = commodity;
        this.colorInfo = colorInfo;
        this.number = number;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public ColorInfo getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(ColorInfo colorInfo) {
        this.colorInfo = colorInfo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}