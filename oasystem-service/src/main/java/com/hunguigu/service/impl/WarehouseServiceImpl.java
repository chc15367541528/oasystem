package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.WarehouseDao;
import com.hunguigu.service.WarehouseService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    WarehouseDao warehouseDao;

    @Override
    public PageVo<Warehouse> query(Warehouse warehouse, int page, int rows) {
        PageVo<Warehouse> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(warehouseDao.query(warehouse));
        pageVo.setTotal(warehouseDao.queryTotal(warehouse));

        return pageVo;
    }

    @Override
    public Warehouse queryById(int id) {
        return warehouseDao.queryById(id);
    }

    @Override
    public int insert(Warehouse warehouse) {
        return warehouseDao.insert(warehouse);
    }

    @Override
    public int delete(int id) {
        return warehouseDao.delete(id);
    }

    @Override
    public int update(Warehouse warehouse) {
        return warehouseDao.update(warehouse);
    }

    @Override
    public List<Warehouse> queryAll() {
        return warehouseDao.query(new Warehouse());
    }
}
