package com.hunguigu.vo;

/**
 *商户入驻信息申请表
 */
public class SettlementApply {
    private Integer id;

    private User user;//用户对象

    private Integer type;//申请类型 1-商户信息修改/2-申请入驻商户

    private Integer state;//状态 0未审核/1通过/2驳回

    private String remark;//备注

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}