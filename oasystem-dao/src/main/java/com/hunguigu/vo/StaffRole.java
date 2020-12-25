package com.hunguigu.vo;

public class StaffRole {
    private Integer srId;
    private Integer sid;
    private Integer rid;

    public StaffRole() {
    }

    public StaffRole(Integer srId, Integer sid, Integer rid) {
        this.srId = srId;
        this.sid = sid;
        this.rid = rid;
    }

    public Integer getSrId() {
        return srId;
    }

    public void setSrId(Integer srId) {
        this.srId = srId;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "srId=" + srId +
                ", sid=" + sid +
                ", rid=" + rid +
                '}';
    }
}
