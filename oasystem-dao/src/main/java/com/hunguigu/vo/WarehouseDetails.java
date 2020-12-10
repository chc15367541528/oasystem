package com.hunguigu.vo;

/**
 *  仓库商品详情表
 */
public class WarehouseDetails {
    private Integer id;

    private Warehouse warehouse;//主仓库对象

    private Commodity commodity;//商品对象

    private Integer number;//商品数量

    private Integer min_number;//最低库存

    private String remark;//备注

    public WarehouseDetails() {
    }

    public WarehouseDetails(Integer id, Warehouse warehouse, Commodity commodity, Integer number, Integer min_number, String remark) {
        this.id = id;
        this.warehouse = warehouse;
        this.commodity = commodity;
        this.number = number;
        this.min_number = min_number;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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

    public Integer getMin_number() {
        return min_number;
    }

    public void setMin_number(Integer min_number) {
        this.min_number = min_number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}