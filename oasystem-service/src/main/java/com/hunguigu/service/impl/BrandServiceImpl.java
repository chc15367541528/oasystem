package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.BrandDao;
import com.hunguigu.service.BrandService;
import com.hunguigu.vo.Brand;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDao brandDao;

    @Override
    public PageVo<Brand> query(Brand brand, int page, int rows) {
        PageVo<Brand> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(brandDao.query(brand));
        pageVo.setTotal(brandDao.queryTotal(brand));

        return pageVo;
    }

    @Override
    public Brand queryById(int id) {
        return brandDao.queryById(id);
    }

    @Override
    public int insert(Brand brand) {
        return brandDao.insert(brand);
    }

    @Override
    public int delete(int id) {
        return brandDao.delete(id);
    }

    @Override
    public int update(Brand brand) {
        return brandDao.update(brand);
    }

    @Override
    public List<Brand> queryAll() {
        return brandDao.query(new Brand());
    }
}
