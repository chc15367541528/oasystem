package com.hunguigu.dao;

import com.hunguigu.vo.MenuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuInfoDao {
    /**
     * 根据父id,菜单类型 查询子菜单信息
     *
     * @param pid   父id
     * @param nodeType 菜单类型
     * @return
     */
    public List<MenuInfo> queryChildMenuByPidAndMenuType(@Param("pid") int pid, @Param("nodeType") int nodeType);


    /**
     * 根据角色id查询当前可操作的菜单
     * @param rid  角色id
     * @return
     */
    public List<Integer> queryMenuIdByRid(int rid);
}
