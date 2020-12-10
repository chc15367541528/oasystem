package com.hunguigu.service;

import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.WarehouseAllot;

import java.util.List;

public interface WarehouseAllotService {

    public PageVo<WarehouseAllot> query(WarehouseAllot warehouseAllot, int page, int rows);

    public WarehouseAllot queryById(int id);

    public int insert(WarehouseAllot warehouseAllot);

    public int delete(int id);

    public int update(WarehouseAllot warehouseAllot);

    public List<WarehouseAllot> queryAll();

}
