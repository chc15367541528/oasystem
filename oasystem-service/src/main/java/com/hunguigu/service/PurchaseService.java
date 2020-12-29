package com.hunguigu.service;

import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Purchase;

import java.util.List;

public interface PurchaseService {

    public PageVo<Purchase> query(Purchase purchase, int page, int rows);

    public Purchase queryById(int id);

    public int insert(Purchase purchase);

    public int delete(int id);

    public int update(Purchase purchase);

    public List<Purchase> queryAll();

}
