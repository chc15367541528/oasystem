package com.hunguigu.service;

import com.hunguigu.vo.PageVo;
import com.hunguigu.vo.Role;

import java.util.List;

public interface RoleService {

    public PageVo<Role> query(Role role, int page, int rows);

    public Role queryById(int id);

    public int insert(Role role);

    public int delete(int id);

    public int update(Role role);

    public List<Role> queryAll();

}
