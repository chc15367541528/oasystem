package com.hunguigu.dao;

import com.hunguigu.vo.Commodity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao {

    public List<Commodity> query(Commodity commodity);

    public Commodity queryById(int id);

    public int queryTotal(Commodity commodity);

    public int insert(Commodity commodity);

    public int delete(int id);

    public int update(Commodity commodity);

}