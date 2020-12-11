package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.ColorInfoDao;
import com.hunguigu.service.ColorInfoService;
import com.hunguigu.vo.ColorInfo;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorInfoServiceImpl implements ColorInfoService {

    @Autowired
    ColorInfoDao dao;

    @Override
    public PageVo<ColorInfo> query(ColorInfo colorInfo, int page, int rows) {
        PageVo<ColorInfo> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(dao.query(colorInfo));
        pageVo.setTotal(dao.queryTotal(colorInfo));

        return pageVo;
    }

    @Override
    public ColorInfo queryById(int id) {
        return dao.queryById(id);
    }

    @Override
    public int insert(ColorInfo colorInfo) {
        return dao.insert(colorInfo);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(ColorInfo colorInfo) {
        return dao.update(colorInfo);
    }

    @Override
    public List<ColorInfo> queryAll() {
        return dao.query(new ColorInfo());
    }
}
