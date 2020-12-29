package com.hunguigu.service;

import com.hunguigu.vo.ImgInfo;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface ImgInfoService {

    public PageVo<ImgInfo> query(ImgInfo imgInfo, int page, int rows);

    public List<ImgInfo> queryAll(ImgInfo imgInfo);

    public ImgInfo queryById(int id);

    public int insert(ImgInfo imgInfo);

    public int delete(int id);

    public int update(ImgInfo imgInfo);

}
