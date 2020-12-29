package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.MenuDao;
import com.hunguigu.service.MenuService;
import com.hunguigu.vo.Menu;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    //通过条件查询
    @Override
    public PageVo<Menu> queryMenuCount(Menu menu, int page, int rows) {
        PageVo<Menu> pageVo = new PageVo<>();
        //放在 查询代码的前面
        PageHelper.startPage(page, rows);
        pageVo.setRows(menuDao.queryMenu(menu));

        pageVo.setTotal(menuDao.queryMenuCount(menu));

        return pageVo;
    }

    //添加
    @Override
    public int addMenu(Menu menu) {
        return menuDao.addMenu(menu);
    }

    //修改
    @Override
    public int updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }

    //批量删除
    @Override
    public int deletePLMenu(String[] id) {
        return menuDao.deletePLMenu(id);
    }

    //删除
    @Override
    public int deleteMenu(int id) {
        return menuDao.deleteMenu(id);
    }

    //通过父id查询
    @Override
    public List<Menu> queryByPid() {
        return menuDao.queryByPid();
    }

    @Override
    public List<Menu> queryAllLeftMenu(int staid) {

        //查询所有的父菜单  父节点为0  菜单类型为1
        List<Menu> menus = menuDao.queryChilder(0);

        //将所有的父菜单的子菜单查询出来，绑定好
        for (Menu menu : menus) {
            List<Menu> childsmenu = menuDao.querymenuBypidandsid(staid, menu.getId().intValue());
            menu.setChildMenu(childsmenu);

        }
        return menus;
    }

    @Override
    public List<Menu> queryAllMenuNodeType(int staid) {

        //查询所有的父菜单  父节点为0  菜单类型为1
        List<Menu> menus = menuDao.queryMenuByNodeTypeAndSid(staid);

        return menus;
    }

    @Override
    public List<Menu> queryAuthorMenu(int staid) {
        //查询出顶级菜单
        List<Menu> list = menuDao.queryNodeType(1);
        List<Menu> staM = menuDao.querymenuBypidandsid(staid, 0);
        for (Menu menu : list) {
            menu.setLabel(menu.getName());
            //设置所有的子菜单权限 二级菜单
            menu.setChildren(menuDao.queryChilder(menu.getId()));
            //获取当前这个菜单的 员工权限1
            List<Menu> staMenu = menuDao.querymenuBypidandsid(staid, menu.getId().intValue());
            ////循环判断 把禁用改为false此为1一级
            for (Menu st : staM) {
                if (menu.getId() == st.getId()) {
                    menu.setDisabled(false);
                }
            }
            for (Menu menu1 : menu.getChildren()) {
                //获取当前这个菜单的 员工权限2
                List<Menu> staMenu2 = menuDao.querymenuBypidandsid(staid, menu1.getId().intValue());
                //设置当前这个菜单的所有子菜单 三级菜单
                menu1.setChildren(menuDao.queryChilder(menu1.getId()));
                //设置标签名
                menu1.setLabel(menu1.getName());
                //循环判断 把禁用改为false此为二级
                for (Menu sta : staMenu) {
                    if (menu1.getId() == sta.getId()) {
                        menu1.setDisabled(false);
                    }
                }
                //设置二级菜单的子菜单（三级菜单）
                for (Menu menu3 : menu1.getChildren()) {
                    //获取当前这个菜单的 员工权限2
                    List<Menu> staMenu3 = menuDao.querymenuBypidandsid(staid, menu3.getId().intValue());
                    //设置当前这个菜单的所有子菜单 三级菜单
                    menu3.setChildren(menuDao.queryChilder(menu3.getId()));
                    //设置标签名
                    menu3.setLabel(menu3.getName());
                    //循环判断 把禁用改为false此为三级
                    for (Menu sta2 : staMenu2) {
                        if (menu3.getId() == sta2.getId()) {
                            menu3.setDisabled(false);
                        }
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<Menu> queryStaffAuthorMenu(int staid) {
        return null;
    }


}
