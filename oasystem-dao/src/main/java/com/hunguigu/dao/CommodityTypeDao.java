package com.hunguigu.dao;

import com.hunguigu.vo.CommodityType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityTypeDao {

    public List<CommodityType> query(CommodityType commodityType);

    public CommodityType queryById(int id);

    public int queryTotal(CommodityType commodityType);

    public int insert(CommodityType commodityType);

    public int delete(int id);

    public int update(CommodityType commodityType);

}