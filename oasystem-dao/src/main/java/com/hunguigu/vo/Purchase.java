package com.hunguigu.vo;

import java.util.Date;

public class Purchase {
    private Integer id;

    private String purchase_number;//订单号

    private Date createtime;//订单创建时间

    private Commodity commodity;/*商品id*/

    private Integer number;/*数量*/

    private String remark;//备注

    public Purchase() {
    }

    public Purchase(Integer id, String purchase_number, Date createtime, Commodity commodity, Integer number, String remark) {
        this.id = id;
        this.purchase_number = purchase_number;
        this.createtime = createtime;
        this.commodity = commodity;
        this.number = number;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchase_number() {
        return purchase_number;
    }

    public void setPurchase_number(String purchase_number) {
        this.purchase_number = purchase_number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
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