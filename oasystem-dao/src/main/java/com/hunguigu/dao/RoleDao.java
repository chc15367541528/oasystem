package com.hunguigu.dao;

import com.hunguigu.vo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    public List<Role> query(Role role);

    public Role queryById(int id);

    public int queryTotal(Role role);

    public int insert(Role role);

    public int delete(int id);

    public int update(Role role);
}