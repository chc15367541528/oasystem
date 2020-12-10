package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.ImgInfoDao;
import com.hunguigu.service.ImgInfoService;
import com.hunguigu.vo.ImgInfo;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgInfoServiceImpl implements ImgInfoService {

    @Autowired
    ImgInfoDao imgInfoDao;

    @Override
    public PageVo<ImgInfo> query(ImgInfo imgInfo, int page, int rows) {
        PageVo<ImgInfo> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(imgInfoDao.query(imgInfo));
        pageVo.setTotal(imgInfoDao.queryTotal(imgInfo));

        return pageVo;
    }

    @Override
    public ImgInfo queryById(int id) {
        return imgInfoDao.queryById(id);
    }

    @Override
    public int insert(ImgInfo imgInfo) {
        return imgInfoDao.insert(imgInfo);
    }

    @Override
    public int delete(int id) {
        return imgInfoDao.delete(id);
    }

    @Override
    public int update(ImgInfo imgInfo) {
        return imgInfoDao.update(imgInfo);
    }

    @Override
    public List<ImgInfo> queryAll() {
        return imgInfoDao.query(new ImgInfo());
    }
}
