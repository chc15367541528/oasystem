package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.SettlementApplyDao;
import com.hunguigu.service.SettlementApplyService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.SettlementApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettlementApplyServiceImpl implements SettlementApplyService {

    @Autowired
    SettlementApplyDao settlementApplyDao;

    @Override
    public PageVo<SettlementApply> query(SettlementApply settlementApply, int page, int rows) {
        PageVo<SettlementApply> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(settlementApplyDao.query(settlementApply));
        pageVo.setTotal(settlementApplyDao.queryTotal(settlementApply));

        return pageVo;
    }

    @Override
    public SettlementApply queryById(int id) {
        return settlementApplyDao.queryById(id);
    }

    @Override
    public int insert(SettlementApply settlementApply) {
        return settlementApplyDao.insert(settlementApply);
    }

    @Override
    public int delete(int id) {
        return settlementApplyDao.delete(id);
    }

    @Override
    public int update(SettlementApply settlementApply) {
        return settlementApplyDao.update(settlementApply);
    }

    @Override
    public List<SettlementApply> queryAll() {
        return settlementApplyDao.query(new SettlementApply());
    }
}
