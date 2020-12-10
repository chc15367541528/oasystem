package com.hunguigu.dao;

import com.hunguigu.vo.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDao {

    public List<Brand> query(Brand brand);

    public Brand queryById(int id);

    public int queryTotal(Brand brand);

    public int insert(Brand brand);

    public int delete(int id);

    public int update(Brand brand);

}