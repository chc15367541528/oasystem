package com.hunguigu.dao;

import com.hunguigu.vo.SettlementApply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettlementApplyDao {

    public List<SettlementApply> query(SettlementApply settlementApply);

    public SettlementApply queryById(int id);

    public int queryTotal(SettlementApply settlementApply);

    public int insert(SettlementApply settlementApply);

    public int delete(int id);

    public int update(SettlementApply settlementApply);
}