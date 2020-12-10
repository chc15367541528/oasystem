package com.hunguigu.vo;

/**
 * 用户表
 */
public class User {
    private Integer id;

    private String account;//账号

    private String password;//密码

    private String name;//展示姓名

    private String address;//地址

    private String phone;//电话

    private User merchants;//提货商户对象

    private Float balance;//余额

    private Role role;//角色

    private String storeName;/*店铺名称(默认为空，商户显示)*/

    private String remark;//备注

    public User() {
    }

    public User(Integer id, String account, String password, String name, String address, String phone, User merchants, Float balance, Role role, String storeName, String remark) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.merchants = merchants;
        this.balance = balance;
        this.role = role;
        this.storeName = storeName;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getMerchants() {
        return merchants;
    }

    public void setMerchants(User merchants) {
        this.merchants = merchants;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}