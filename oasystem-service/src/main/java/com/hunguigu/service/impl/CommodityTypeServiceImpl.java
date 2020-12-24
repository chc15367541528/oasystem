package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.CommodityDao;
import com.hunguigu.dao.CommodityTypeDao;
import com.hunguigu.service.CommodityTypeService;
import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.CommodityType;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityTypeServiceImpl implements CommodityTypeService{

    @Autowired
    CommodityTypeDao commodityTypeDao;


    @Override
    public PageVo<CommodityType> query(CommodityType commodityType, int page, int rows) {
        PageVo<CommodityType> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(commodityTypeDao.query(commodityType));
        pageVo.setTotal(commodityTypeDao.queryTotal(commodityType));

        return pageVo;
    }

    @Override
    public CommodityType queryById(int id) {
        return commodityTypeDao.queryById(id);
    }

    @Override
    public int insert(CommodityType commodityType) {
        return commodityTypeDao.insert(commodityType);
    }

    @Override
    public int delete(int id) {
        return commodityTypeDao.delete(id);
    }

    @Override
    public int update(CommodityType commodityType) {
        return commodityTypeDao.update(commodityType);
    }

    @Override
    public List<CommodityType> queryAll() {
        return commodityTypeDao.query(new CommodityType());
    }

}
