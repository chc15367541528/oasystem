package com.hunguigu.vo;

public class StaffRole {
    private Integer srid;
    private Integer staffid;
    private Integer roleid;

    public Integer getSrid() {
        return srid;
    }

    public void setSrid(Integer srid) {
        this.srid = srid;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public StaffRole() {
    }

    public StaffRole(Integer srid, Integer staffid, Integer roleid) {
        this.srid = srid;
        this.staffid = staffid;
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "StaffRole{" +
                "srid=" + srid +
                ", staffid=" + staffid +
                ", roleid=" + roleid +
                '}';
    }
}
