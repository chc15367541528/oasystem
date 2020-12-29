package com.hunguigu.service;

import com.hunguigu.vo.Brand;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface BrandService {

    public PageVo<Brand> query(Brand brand, int page, int rows);

    public Brand queryById(int id);

    public int insert(Brand brand);

    public int delete(int id);

    public int update(Brand brand);

    public List<Brand> queryAll();
}
