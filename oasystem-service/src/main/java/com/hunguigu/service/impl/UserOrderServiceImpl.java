package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.UserOrderDao;
import com.hunguigu.service.UserOrderService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderDao userOrderDao;

    @Override
    public PageVo<UserOrder> query(UserOrder userOrder, int page, int rows) {
        PageVo<UserOrder> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(userOrderDao.query(userOrder));
        pageVo.setTotal(userOrderDao.queryTotal(userOrder));

        System.out.println(pageVo.getRows());

        return pageVo;
    }

    @Override
    public UserOrder queryById(int id) {
        return userOrderDao.queryById(id);
    }

    @Override
    public int insert(UserOrder userOrder) {
        return userOrderDao.insert(userOrder);
    }

    @Override
    public int delete(int id) {
        return userOrderDao.delete(id);
    }

    @Override
    public int update(UserOrder userOrder) {
        return userOrderDao.update(userOrder);
    }

    @Override
    public List<UserOrder> queryAll() {
        return userOrderDao.query(new UserOrder());
    }

    @Override
    public List<UserOrder> queryByState(int state) {
        List<UserOrder> userOrders = userOrderDao.queryByState(state);
        return userOrders;
    }
}
