package com.hunguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hunguigu.dao.RoleDao;
import com.hunguigu.service.RoleService;
import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> queryFenPeiRole() {
        List<Role> list=roleDao.query(new Role());
        for (Role r:list) {
            r.setId(r.getId());
            r.setLabel(r.getName());
        }
        return list;
    }

    @Override
    public PageVo<Role> query(Role role, int page, int rows) {
        PageVo<Role> pageVo = new PageVo<>();

        PageHelper.startPage(page,rows);
        pageVo.setRows(roleDao.query(role));
        pageVo.setTotal(roleDao.queryTotal(role));

        return pageVo;
    }

    @Override
    public Role queryById(int id) {
        return roleDao.queryById(id);
    }

    @Override
    public int insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public int delete(int id) {
        return roleDao.delete(id);
    }

    @Override
    public int update(Role role) {
        return  roleDao.update(role);
    }

    @Override
    public List<Role> queryAll() {
        return roleDao.query(new Role());
    }
}
