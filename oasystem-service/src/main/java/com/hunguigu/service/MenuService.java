package com.hunguigu.service;

import com.hunguigu.vo.Menu;
import com.hunguigu.vo.MenuInfo;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface MenuService {


    /**
     * 查询指定节点类型的菜单信息
     * @param nodeType   节点类型  文件夹 0    页面 1   按钮 3
     * @param rid  角色id   如果角色id为0 不做处理  不为0 设置当前角色id的权限菜单checked状态
     * @returnT
     */
    public List<MenuInfo> queryAllMenus(int nodeType, int rid);

    public PageVo<Menu> query(Menu menu, int page, int rows);

    public Menu queryById(int id);

    public int insert(Menu menu);

    public int delete(int id);

    public int update(Menu menu);

    public List<Menu> queryAll();

}
