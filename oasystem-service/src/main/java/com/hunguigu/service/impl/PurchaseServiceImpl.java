package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.PurchaseDao;
import com.hunguigu.service.PurchaseService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;

    @Override
    public PageVo<Purchase> query(Purchase purchase, int page, int rows) {
        PageVo<Purchase> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(purchaseDao.query(purchase));
        pageVo.setTotal(purchaseDao.queryTotal(purchase));

        return pageVo;
    }

    @Override
    public Purchase queryById(int id) {
        return purchaseDao.queryById(id);
    }

    @Override
    public int insert(Purchase purchase) {
        return purchaseDao.insert(purchase);
    }

    @Override
    public int delete(int id) {
        return purchaseDao.delete(id);
    }

    @Override
    public int update(Purchase purchase) {
        return purchaseDao.update(purchase);
    }

    @Override
    public List<Purchase> queryAll() {
        return purchaseDao.query(new Purchase());
    }
}
