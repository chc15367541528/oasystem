package com.hunguigu.vo;

/**
 *  仓库调拨表
 */
public class WarehouseAllot {
    private Integer id;

    private Warehouse warehouse;/*发起调拨仓库id*/

    private Warehouse warehouse2;/*接收调拨仓库id*/

    private Staff staff;/*操作员id*/

    private Commodity commodity;/*商品id*/

    private Integer number;/*商品数量*/

    private Integer type;/*调拨类型(0商品调拨入库/1商品调拨出库)*/

    private Integer state;/*状态(0未审核/1通过/2拒收)*/

    public WarehouseAllot() {
    }

    public WarehouseAllot(Integer id, Warehouse warehouse, Warehouse warehouse2, Staff staff, Commodity commodity, Integer number, Integer type, Integer state) {
        this.id = id;
        this.warehouse = warehouse;
        this.warehouse2 = warehouse2;
        this.staff = staff;
        this.commodity = commodity;
        this.number = number;
        this.type = type;
        this.state = state;
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

    public Warehouse getWarehouse2() {
        return warehouse2;
    }

    public void setWarehouse2(Warehouse warehouse2) {
        this.warehouse2 = warehouse2;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
