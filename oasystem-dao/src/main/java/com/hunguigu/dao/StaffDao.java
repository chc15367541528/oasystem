package com.hunguigu.dao;

import com.hunguigu.vo.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {

    public List<Staff> query(Staff staff);

    public Staff queryById(int id);

    public int queryTotal(Staff staff);

    public int insert(Staff staff);

    public int delete(int id);

    public int update(Staff staff);

}