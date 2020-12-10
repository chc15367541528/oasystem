package com.hunguigu.dao;

import com.hunguigu.vo.WarehouseAllot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseAllotDao {

    public List<WarehouseAllot> query(WarehouseAllot warehouseAllot);

    public WarehouseAllot queryById(int id);

    public int queryTotal(WarehouseAllot warehouseAllot);

    public int insert(WarehouseAllot warehouseAllot);

    public int delete(int id);

    public int update(WarehouseAllot warehouseAllot);

}