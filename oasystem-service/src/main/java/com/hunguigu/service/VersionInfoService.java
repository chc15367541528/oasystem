package com.hunguigu.service;

import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.VersionInfo;

import java.util.List;

public interface VersionInfoService {

    public PageVo<VersionInfo> query(VersionInfo versionInfo, int page, int rows);

    public List<VersionInfo> queryAll(VersionInfo versionInfo);

    public List<VersionInfo> queryByCommodityId(int id);

    public VersionInfo queryById(int id);

    public int insert(VersionInfo versionInfo);

    public int delete(int id);

    public int update(VersionInfo versionInfo);

}
