package com.hunguigu.service;

import com.hunguigu.vo.Authority;
import com.hunguigu.vo.PageVo;

import java.util.List;

public interface AuthorityService {

    public PageVo<Authority> query(Authority authority, int page, int rows);

    public Authority queryById(int id);

    public int insert(Authority authority);

    public int delete(int id);

    public int update(Authority authority);

    public List<Authority> queryAll();

}
