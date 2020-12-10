package com.hunguigu.service;

import com.hunguigu.vo.Authority;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    public PageVo<ShoppingCart> query(ShoppingCart shoppingCart, int page, int rows);

    public ShoppingCart queryById(int id);

    public int insert(ShoppingCart shoppingCart);

    public int delete(int id);

    public int update(ShoppingCart shoppingCart);

    public List<ShoppingCart> queryAll();

}
