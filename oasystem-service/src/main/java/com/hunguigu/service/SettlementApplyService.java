package com.hunguigu.service;

import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.SettlementApply;

import java.util.List;

public interface SettlementApplyService {

    public PageVo<SettlementApply> query(SettlementApply settlementApply, int page, int rows);

    public SettlementApply queryById(int id);

    public int insert(SettlementApply settlementApply);

    public int delete(int id);

    public int update(SettlementApply settlementApply);

    public List<SettlementApply> queryAll();

}
