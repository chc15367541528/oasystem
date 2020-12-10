package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.VersionInfoDao;
import com.hunguigu.service.VersionInfoService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.VersionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionInfoServiceImpl implements VersionInfoService {

    @Autowired
    VersionInfoDao dao;

    @Override
    public PageVo<VersionInfo> query(VersionInfo versionInfo, int page, int rows) {
        PageVo<VersionInfo> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(dao.query(versionInfo));
        pageVo.setTotal(dao.queryTotal(versionInfo));

        return pageVo;
    }

    @Override
    public VersionInfo queryById(int id) {
        return dao.queryById(id);
    }

    @Override
    public int insert(VersionInfo versionInfo) {
        return dao.insert(versionInfo);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(VersionInfo versionInfo) {
        return dao.update(versionInfo);
    }

    @Override
    public List<VersionInfo> queryAll() {
        return dao.query(new VersionInfo());
    }
}
