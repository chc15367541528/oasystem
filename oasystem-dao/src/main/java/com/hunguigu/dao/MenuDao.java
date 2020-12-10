package com.hunguigu.dao;

import com.hunguigu.vo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {

    public List<Menu> query(Menu menu);

    public Menu queryById(int id);

    public int queryTotal(Menu menu);

    public int insert(Menu menu);

    public int delete(int id);

    public int update(Menu menu);

}