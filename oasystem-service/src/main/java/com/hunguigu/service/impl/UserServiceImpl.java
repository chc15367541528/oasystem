package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.UserDao;
import com.hunguigu.service.UserService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public PageVo<User> query(User user, int page, int rows) {
        PageVo<User> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(userDao.query(user));
        pageVo.setTotal(userDao.queryTotal(user));

        return pageVo;
    }

    @Override
    public User queryById(int id) {
        return userDao.queryById(id);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> queryAll() {
        return userDao.query(new User());
    }
}
