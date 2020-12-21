package com.hunguigu.dao;

import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.WarehouseDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseDetailsDao {

    public List<WarehouseDetails> query(WarehouseDetails warehouseDetails);

    public WarehouseDetails queryById(int id);

    public int queryTotal(WarehouseDetails warehouseDetails);

    public int insert(WarehouseDetails warehouseDetails);

    public int delete(int id);

    public int update(WarehouseDetails warehouseDetails);

    public List<Commodity> queryComByWarehouseId(int warehouseId);

}