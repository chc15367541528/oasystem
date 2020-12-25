package com.hunguigu.dao;

import com.hunguigu.vo.RoleMenu;

import java.util.List;

public interface RoleMenuDao {

    //通过角色id查询拥有的 菜单  选中的菜单
    public List<RoleMenu> queryAllRoleMenu(int rid);

    //添加
    public int addRM(RoleMenu roleMenu);

    //删除
    public int deleteRoleid(int rid);

    //判断是否有某个菜单被角色引用，如果有不能删除
    public int queryRMMid(int mid);

}
