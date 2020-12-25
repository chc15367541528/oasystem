package com.hunguigu.vo;

public class RoleMenu {

    private Integer rmId;

    private Integer mid;

    private Integer rid;

    public RoleMenu() {
    }

    public RoleMenu(Integer rmId, Integer mid, Integer rid) {
        this.rmId = rmId;
        this.mid = mid;
        this.rid = rid;
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "rmId=" + rmId +
                ", mid=" + mid +
                ", rid=" + rid +
                '}';
    }
}
