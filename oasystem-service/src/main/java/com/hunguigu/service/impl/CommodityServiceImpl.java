package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.CommodityDao;
import com.hunguigu.dao.VersionInfoDao;
import com.hunguigu.service.CommodityService;
import com.hunguigu.vo.Commodity;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.VersionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityDao commodityDao;
    @Autowired
    VersionInfoDao versionInfoDao;


    @Override
    public PageVo<Commodity> query(Commodity commodity, int page, int rows) {
        PageVo<Commodity> pageVo = new PageVo<>();

        PageHelper.startPage(page, rows);
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
        return commodityDao.update(commodity);
    }

    @Override
    public List<Commodity> queryAll(Commodity commodity) {
        List<Commodity> list = commodityDao.query(commodity);

        for (Commodity commodity2 : list) {
            String price = versionInfoDao.queryByCommodityId(commodity2.getId()).get(0).getPrice().toString();
            commodity2.setMinPrice(price);
        }

        return list;
    }

}
