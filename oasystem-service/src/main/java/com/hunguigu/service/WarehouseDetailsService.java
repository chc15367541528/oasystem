package com.hunguigu.service;

import com.hunguigu.vo.Authority;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.WarehouseDetails;

import java.util.List;

public interface WarehouseDetailsService {

    public PageVo<WarehouseDetails> query(WarehouseDetails warehouseDetails, int page, int rows);

    public WarehouseDetails queryById(int id);

    public int insert(WarehouseDetails warehouseDetails);

    public int delete(int id);

    public int update(WarehouseDetails warehouseDetails);

    public List<WarehouseDetails> queryAll();

}
