package com.hunguigu.dao;

import com.hunguigu.vo.ColorInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorInfoDao {

    public List<ColorInfo> query(ColorInfo colorInfo);

    public ColorInfo queryById(int id);

    public int queryTotal(ColorInfo colorInfo);

    public int insert(ColorInfo colorInfo);

    public int delete(int id);

    public int update(ColorInfo colorInfo);
}