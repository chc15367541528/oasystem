package com.hunguigu.service.impl;

import com.hunguigu.dao.StaffRoleDao;
import com.hunguigu.service.StaffRoleService;
import com.hunguigu.vo.StaffRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffRoleServiceImpl implements StaffRoleService {

    @Autowired
    StaffRoleDao staffRoleDao;

    //通过员工id查询拥有的 角色 选中的角色
    @Override
    public List<StaffRole> queryAllStaffRole(int staffid) {
        return staffRoleDao.queryAllStaffRole(staffid);
    }

    //添加
    @Override
    public int addSR(StaffRole staffRole) {
        return staffRoleDao.addSR(staffRole);
    }

    //删除
    @Override
    public int deleteStaffid(int staffid) {
        return staffRoleDao.deleteStaffid(staffid);
    }

    //判断该角色是否被某些员工引用，如果有不能删除，给出提示信息
    @Override
    public int querySRRoleid(int roleid) {
        return staffRoleDao.querySRRoleid(roleid);
    }
}
