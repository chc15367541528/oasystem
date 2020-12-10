package com.hunguigu.dao;

import com.hunguigu.vo.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseDao {

    public List<Warehouse> query(Warehouse warehouse);

    public Warehouse queryById(int id);

    public int queryTotal(Warehouse warehouse);

    public int insert(Warehouse warehouse);

    public int delete(int id);

    public int update(Warehouse warehouse);

}