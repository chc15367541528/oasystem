package com.hunguigu.service;

import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface CommodityService {

    public PageVo<Commodity> query(Commodity commodity, int page, int rows);

    public List<Commodity> querySaleNum();

    public Commodity queryById(int id);

    public int insert(Commodity commodity);

    public int delete(int id);

    public int update(Commodity commodity);

    public List<Commodity> queryAll(Commodity commodity);

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
