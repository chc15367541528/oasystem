package com.hunguigu.service;

import com.hunguigu.vo.ColorInfo;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface ColorInfoService {

    public PageVo<ColorInfo> query(ColorInfo colorInfo, int page, int rows);

    public ColorInfo queryById(int id);

    public int insert(ColorInfo colorInfo);

    public int delete(int id);

    public int update(ColorInfo colorInfo);

    public List<ColorInfo> queryAll();

}
