package com.hunguigu.vo;

public class RoleMenu {

    private Integer rmid;

    private Integer mid;

    private Integer rid;

    public RoleMenu(Integer rmid, Integer mid, Integer rid) {
        this.rmid = rmid;
        this.mid = mid;
        this.rid = rid;
    }

    public RoleMenu() {
    }

    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
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
                "rmid=" + rmid +
                ", mid=" + mid +
                ", rid=" + rid +
                '}';
    }
}
