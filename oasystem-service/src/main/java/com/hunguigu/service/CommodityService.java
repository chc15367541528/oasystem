package com.hunguigu.service;

import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface CommodityService {

    public PageVo<Commodity> query(Commodity commodity, int page, int rows);

    public Commodity queryById(int id);

    public int insert(Commodity commodity);

    public int delete(int id);

    public int update(Commodity commodity);

    public List<Commodity> queryAll();


}
