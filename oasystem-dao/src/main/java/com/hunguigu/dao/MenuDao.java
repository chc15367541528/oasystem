package com.hunguigu.dao;

import com.hunguigu.vo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {

    //通过条件查询
    public List<Menu> queryMenu(Menu menu);

    //通过条件查询记录
    public int queryMenuCount(Menu menu);

    //添加
    public int addMenu(Menu menu);

    //修改
    public int updateMenu(Menu menu);

    //批量删除
    public int deletePLMenu(String[] id);

    //删除
    public int deleteMenu(int id);

    //查询父菜单
    public List<Menu> queryByPid();

    //查询子菜单
    public List<Menu> queryChilder(long id);

    //查询 级数 菜单
    public List<Menu> queryNodeType(int id);

    //通过员工id和父id查询
    public List<Menu> querymenuBypidandsid(@Param("id") int id,
                                           @Param("pid") int pid);

}
