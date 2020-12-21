package com.hunguigu.service;

import com.hunguigu.vo.Authority;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.UserOrder;

import java.util.List;

public interface UserOrderService {

    public PageVo<UserOrder> query(UserOrder userOrder, int page, int rows);

    public UserOrder queryById(int id);

    public int insert(UserOrder userOrder);

    public int delete(int id);

    public int update(UserOrder userOrder);

    public List<UserOrder> queryAll();

    //通过订单状态查询订单信息
    public List<UserOrder> queryByState(int state);


}
