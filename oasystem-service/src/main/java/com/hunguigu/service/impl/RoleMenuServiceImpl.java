package com.hunguigu.service.impl;

import com.hunguigu.dao.RoleMenuDao;
import com.hunguigu.service.RoleMenuService;
import com.hunguigu.vo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    RoleMenuDao roleMenuDao;

    @Override
    public List<RoleMenu> queryAllRoleMenu(int roleId) {

        return roleMenuDao.queryAllRoleMenu(roleId);
    }

    //添加
    @Override
    public int addRM(RoleMenu roleMenu) {
        return roleMenuDao.addRM(roleMenu);
    }

    //删除
    @Override
    public int deleteRoleid(int roleid) {
        return roleMenuDao.deleteRoleid(roleid);
    }

    //判断是否有某个菜单被角色引用，如果有不能删除
    @Override
    public int queryRMMid(int mid) {
        return roleMenuDao.queryRMMid(mid);
    }
}
