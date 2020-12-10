package com.hunguigu.service;

import com.hunguigu.vo.Menu;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface MenuService {

    public PageVo<Menu> query(Menu menu, int page, int rows);

    public Menu queryById(int id);

    public int insert(Menu menu);

    public int delete(int id);

    public int update(Menu menu);

    public List<Menu> queryAll();

}
