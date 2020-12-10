package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.ShoppingCartDao;
import com.hunguigu.service.ShoppingCartService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Override
    public PageVo<ShoppingCart> query(ShoppingCart shoppingCart, int page, int rows) {
        PageVo<ShoppingCart> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(shoppingCartDao.query(shoppingCart));
        pageVo.setTotal(shoppingCartDao.queryTotal(shoppingCart));

        return pageVo;
    }

    @Override
    public ShoppingCart queryById(int id) {
        return shoppingCartDao.queryById(id);
    }

    @Override
    public int insert(ShoppingCart shoppingCart) {
        return shoppingCartDao.insert(shoppingCart);
    }

    @Override
    public int delete(int id) {
        return shoppingCartDao.delete(id);
    }

    @Override
    public int update(ShoppingCart shoppingCart) {
        return shoppingCartDao.update(shoppingCart);
    }

    @Override
    public List<ShoppingCart> queryAll() {
        return shoppingCartDao.query(new ShoppingCart());
    }
}
