package com.hunguigu.vo;

public class VersionInfo {
    private Integer id;
    private Commodity commodity;/*商品*/
    private String version;/*版本*/
    private String remark;

    public VersionInfo() {
    }

    public VersionInfo(Integer id, Commodity commodity, String version, String remark) {
        this.id = id;
        this.commodity = commodity;
        this.version = version;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
