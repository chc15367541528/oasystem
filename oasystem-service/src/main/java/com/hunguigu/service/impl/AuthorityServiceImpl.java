package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.AuthorityDao;
import com.hunguigu.service.AuthorityService;
import com.hunguigu.vo.Authority;
import com.hunguigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityDao authorityDao;

    @Override
    public PageVo<Authority> query(Authority authority, int page, int rows) {
        PageVo<Authority> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(authorityDao.query(authority));
        pageVo.setTotal(authorityDao.queryTotal(authority));

        return pageVo;
    }

    @Override
    public Authority queryById(int id) {
        return authorityDao.queryById(id);
    }

    @Override
    public int insert(Authority authority) {
        return authorityDao.insert(authority);
    }

    @Override
    public int delete(int id) {
        return authorityDao.delete(id);
    }

    @Override
    public int update(Authority authority) {
        return authorityDao.update(authority);
    }

    @Override
    public List<Authority> queryAll() {
        return authorityDao.query(new Authority());
    }
}
