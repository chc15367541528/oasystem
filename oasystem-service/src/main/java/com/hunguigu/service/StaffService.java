package com.hunguigu.service;

import com.hunguigu.vo.Authority;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Staff;

import java.util.List;

public interface StaffService {

    public PageVo<Staff> query(Staff staff, int page, int rows);

    public Staff queryById(int id);

    public int insert(Staff staff);

    public int delete(int id);

    public int update(Staff staff);

    public List<Staff> queryAll();

}
