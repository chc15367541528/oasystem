package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.MenuDao;
import com.hunguigu.service.MenuService;
import com.hunguigu.vo.Menu;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

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
