package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.MenuDao;
import com.hunguigu.dao.MenuInfoDao;
import com.hunguigu.service.MenuService;
import com.hunguigu.vo.Menu;
import com.hunguigu.vo.MenuInfo;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;
    @Autowired
    MenuInfoDao menuInfoDao;

    /**
     * 根据菜单节点类型 拼装菜单数据
     * 首先菜单显示用到，授权页面显示也用到
     * 此处考虑用递归进行封装
     *
     * @param nodetype
     * @param rid      角色id   如果角色id为0 不做处理  不为0 设置当前角色id的权限菜单checked状态
     * @return
     */
    @Override
    public List<MenuInfo> queryAllMenus(int nodetype, int rid) {
        List<Integer> list = new ArrayList<Integer>();
        //2020-10-12修改
        if (rid != 0) {
            list = menuInfoDao.queryMenuIdByRid(rid);
        }
        //查询所有的父菜单  父节点为0  菜单类型为1
        List<MenuInfo> menus = menuInfoDao.queryChildMenuByPidAndMenuType(0, 1);

        //将所有的父菜单的子菜单查询出来，绑定好
        for (MenuInfo menu : menus) {
            List<MenuInfo> childsmenu = menuInfoDao.queryChildMenuByPidAndMenuType(menu.getId().intValue(), 2);
            menu.setChildMenu(childsmenu);

            //一级节点 选择状态设置 2020-10-12修改
            if (list.contains(menu.getId().intValue())) {
                menu.setChecked(true);
            }

            for (MenuInfo menu2 : childsmenu) {
                List<MenuInfo> childsmenu2 = menuInfoDao.queryChildMenuByPidAndMenuType(menu2.getId().intValue(), 3);

                //二级节点 选择状态设置
                if (list.contains(menu2.getId().intValue())) {
                    menu2.setChecked(true);
                }
                if (nodetype == 3) {
                    menu2.setChildMenu(childsmenu2);

                    for (MenuInfo menu3 : childsmenu2) {
                        //三级节点 选择状态设置
                        if (list.contains(menu3.getId().intValue())) {
                            menu3.setChecked(true);
                        }
                    }
                }
            }
        }
        return menus;
    }

    @Override
    public PageVo<Menu> query(Menu menu, int page, int rows) {
        PageVo<Menu> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(menuDao.query(menu));
        pageVo.setTotal(menuDao.queryTotal(menu));

        return pageVo;
    }

    @Override
    public Menu queryById(int id) {
        return menuDao.queryById(id);
    }

    @Override
    public int insert(Menu menu) {
        return menuDao.insert(menu);
    }

    @Override
    public int delete(int id) {
        return menuDao.delete(id);
    }

    @Override
    public int update(Menu menu) {
        return menuDao.update(menu);
    }

    @Override
    public List<Menu> queryAll() {
        return menuDao.query(new Menu());
    }
}
