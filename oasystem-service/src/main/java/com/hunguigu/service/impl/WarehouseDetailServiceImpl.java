package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.WarehouseDao;
import com.hunguigu.dao.WarehouseDetailsDao;
import com.hunguigu.service.WarehouseDetailsService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.WarehouseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseDetailServiceImpl implements WarehouseDetailsService {

    @Autowired
    WarehouseDetailsDao warehouseDetailsDao;


    @Override
    public PageVo<WarehouseDetails> query(WarehouseDetails warehouseDetails, int page, int rows) {
        PageVo<WarehouseDetails> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(warehouseDetailsDao.query(warehouseDetails));
        pageVo.setTotal(warehouseDetailsDao.queryTotal(warehouseDetails));

        return pageVo;
    }

    @Override
    public WarehouseDetails queryById(int id) {
        return warehouseDetailsDao.queryById(id);
    }

    @Override
    public int insert(WarehouseDetails warehouseDetails) {
        return warehouseDetailsDao.insert(warehouseDetails);
    }

    @Override
    public int delete(int id) {
        return warehouseDetailsDao.delete(id);
    }

    @Override
    public int update(WarehouseDetails warehouseDetails) {
        return warehouseDetailsDao.update(warehouseDetails);
    }

    @Override
    public List<WarehouseDetails> queryAll() {
        return warehouseDetailsDao.query(new WarehouseDetails());
    }
}
