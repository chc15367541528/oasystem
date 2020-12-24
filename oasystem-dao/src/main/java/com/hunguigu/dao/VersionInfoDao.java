package com.hunguigu.dao;

import com.hunguigu.vo.VersionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionInfoDao {

    public List<VersionInfo> query(VersionInfo versionInfo);

    public List<VersionInfo> queryByCommodityId(int id);

    public VersionInfo queryById(int id);

    public int queryTotal(VersionInfo versionInfo);

    public int insert(VersionInfo versionInfo);

    public int delete(int id);

    public int update(VersionInfo versionInfo);

}