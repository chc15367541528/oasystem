package com.hunguigu.service;

import com.hunguigu.vo.Menu;
import com.hunguigu.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    //通过条件查询
    public PageVo<Menu> queryMenuCount(Menu menu, int page, int rows);

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

    //查询左边菜单
    List<Menu> queryAllLeftMenu(int sid);

    //查询授权菜单
    List<Menu> queryAuthorMenu(int staid);

    //综合 二合一
    List<Menu> queryStaffAuthorMenu(int staid);

}
