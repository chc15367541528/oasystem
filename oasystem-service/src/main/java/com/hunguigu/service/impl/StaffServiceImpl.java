package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.StaffDao;
import com.hunguigu.service.StaffService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Staff;
import com.hunguigu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffDao staffDao;

    @Override
    public PageVo<Staff> query(Staff staff, int page, int rows) {
        PageVo<Staff> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(staffDao.query(staff));
        pageVo.setTotal(staffDao.queryTotal(staff));

        return pageVo;
    }

    @Override
    public Staff queryById(int id) {
        return staffDao.queryById(id);
    }

    @Override
    public int insert(Staff staff) {
        return staffDao.insert(staff);
    }

    @Override
    public int delete(int id) {
        return staffDao.delete(id);
    }

    @Override
    public int update(Staff staff) {
        return staffDao.update(staff);
    }

    @Override
    public List<Staff> queryAll() {
        return staffDao.query(new Staff());
    }

    @Override
    public Staff staffDengLu(Staff staff){
        return staffDao.staffDengLu(staff);
    }
}
