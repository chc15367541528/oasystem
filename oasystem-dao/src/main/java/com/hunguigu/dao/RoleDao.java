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

    /**
     * 根据用户id，查询当前用户拥有的角色信息
     * @param uid  用户id
     * @return 角色信息集合
     */
    public List<Role> queryRolesByUid(int uid);
}