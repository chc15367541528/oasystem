package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.WarehouseAllotDao;
import com.hunguigu.service.WarehouseAllotService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.WarehouseAllot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseAllotServiceImpl implements WarehouseAllotService {

    @Autowired
    WarehouseAllotDao dao;

    @Override
    public PageVo<WarehouseAllot> query(WarehouseAllot warehouseAllot, int page, int rows) {
        PageVo<WarehouseAllot> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(dao.query(warehouseAllot));
        pageVo.setTotal(dao.queryTotal(warehouseAllot));

        return pageVo;
    }

    @Override
    public WarehouseAllot queryById(int id) {
        return dao.queryById(id);
    }

    @Override
    public int insert(WarehouseAllot warehouseAllot) {
        return dao.insert(warehouseAllot);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(WarehouseAllot warehouseAllot) {
        return dao.update(warehouseAllot);
    }

    @Override
    public List<WarehouseAllot> queryAll() {
        return dao.query(new WarehouseAllot());
    }
}
