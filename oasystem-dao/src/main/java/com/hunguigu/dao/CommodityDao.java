package com.hunguigu.dao;

import com.hunguigu.vo.Commodity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao {

    public List<Commodity> query(Commodity commodity);

    public List<Commodity> querySaleNum();

    public Commodity queryById(int id);

    public int queryTotal(Commodity commodity);

    public int insert(Commodity commodity);

    public int delete(int id);

    public int update(Commodity commodity);

    /**
     * 根据商品仓库id查询出不属于该仓库的商品
     * @param warehouseId
     * @return
     */
    public List<Commodity> queryComByWarehouseIdNot(int warehouseId);

    /**
     * 根据商品仓库id查询出属于该仓库的商品
     * @param warehouseId
     * @return
     */
    public List<Commodity> queryComByWarehouseId(int warehouseId);
}