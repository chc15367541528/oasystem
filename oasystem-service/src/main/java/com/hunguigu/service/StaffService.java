package com.hunguigu.service;

import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Staff;

import java.util.List;

public interface StaffService {

    public Staff staffDengLu(Staff staff);

    public PageVo<Staff> query(Staff staff, int page, int rows);

    public Staff queryById(int id);

    public int insert(Staff staff);

    public int delete(int id);

    public int update(Staff staff);

    public List<Staff> queryAll();

}
