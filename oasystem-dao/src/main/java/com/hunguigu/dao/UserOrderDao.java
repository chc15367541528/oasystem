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

}