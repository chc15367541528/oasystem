package com.hunguigu.dao;

import com.hunguigu.vo.UserOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderDao {

    public List<UserOrder> query(UserOrder userOrder);

    public UserOrder queryById(int id);

    public int queryTotal(UserOrder userOrder);

    public int insert(UserOrder userOrder);

    public int delete(int id);

    public int update(UserOrder userOrder);

    //通过订单状态查询订单信息
    public List<UserOrder> queryByState(int state);

    //查询所有订单信息
    public  List<UserOrder> queryAll(UserOrder userOrder);

}