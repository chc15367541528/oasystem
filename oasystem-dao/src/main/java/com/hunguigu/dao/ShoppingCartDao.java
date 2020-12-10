package com.hunguigu.dao;

import com.hunguigu.vo.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartDao {

    public List<ShoppingCart> query(ShoppingCart shoppingCart);

    public ShoppingCart queryById(int id);

    public int queryTotal(ShoppingCart shoppingCart);

    public int insert(ShoppingCart shoppingCart);

    public int delete(int id);

    public int update(ShoppingCart shoppingCart);
}