package com.hunguigu.dao;

import com.hunguigu.vo.Purchase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseDao {

    public List<Purchase> query(Purchase purchase);

    public Purchase queryById(int id);

    public int queryTotal(Purchase purchase);

    public int insert(Purchase purchase);

    public int delete(int id);

    public int update(Purchase purchase);

}