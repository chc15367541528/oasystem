package com.hunguigu.service;

import com.hunguigu.vo.CommodityType;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface CommodityTypeService {

    public PageVo<CommodityType> query(CommodityType commodityType, int page, int rows);

    public CommodityType queryById(int id);

    public int insert(CommodityType commodityType);

    public int delete(int id);

    public int update(CommodityType commodityType);

    public List<CommodityType> queryAll();

}
