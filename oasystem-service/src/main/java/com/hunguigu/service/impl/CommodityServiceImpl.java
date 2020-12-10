package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.CommodityDao;
import com.hunguigu.service.CommodityService;
import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityDao commodityDao;


    @Override
    public PageVo<Commodity> query(Commodity commodity, int page, int rows) {
        PageVo<Commodity> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(commodityDao.query(commodity));
        pageVo.setTotal(commodityDao.queryTotal(commodity));

        return pageVo;
    }

    @Override
    public Commodity queryById(int id) {
        return commodityDao.queryById(id);
    }

    @Override
    public int insert(Commodity commodity) {
        return commodityDao.insert(commodity);
    }

    @Override
    public int delete(int id) {
        return commodityDao.delete(id);
    }

    @Override
    public int update(Commodity commodity) {
        return  commodityDao.update(commodity);
    }

    @Override
    public List<Commodity> queryAll() {
        return commodityDao.query(new Commodity());
    }
}
