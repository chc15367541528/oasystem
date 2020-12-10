package com.hunguigu.service;

import com.hunguigu.vo.Authority;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Warehouse;

import java.util.List;

public interface WarehouseService {

    public PageVo<Warehouse> query(Warehouse warehouse, int page, int rows);

    public Warehouse queryById(int id);

    public int insert(Warehouse warehouse);

    public int delete(int id);

    public int update(Warehouse warehouse);

    public List<Warehouse> queryAll();

}
