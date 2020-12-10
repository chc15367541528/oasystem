package com.hunguigu.dao;

import com.hunguigu.vo.ImgInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgInfoDao {

    public List<ImgInfo> query(ImgInfo imgInfo);

    public ImgInfo queryById(int id);

    public int queryTotal(ImgInfo imgInfo);

    public int insert(ImgInfo imgInfo);

    public int delete(int id);

    public int update(ImgInfo imgInfo);

}