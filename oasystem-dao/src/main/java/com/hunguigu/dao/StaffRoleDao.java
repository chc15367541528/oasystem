package com.hunguigu.dao;

import com.hunguigu.vo.RoleMenu;
import com.hunguigu.vo.StaffRole;

import java.util.List;

public interface StaffRoleDao {

    //通过员工id查询拥有的 角色 选中的角色
    public List<StaffRole> queryAllStaffRole(int staffid);

    //添加
    public int addSR(StaffRole staffRole);

    //删除
    public int deleteStaffid(int staffid);

    //判断该角色是否被某些员工引用，如果有不能删除，给出提示信息
    public int querySRRoleid(int roleid);
}
