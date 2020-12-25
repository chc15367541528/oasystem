package com.hunguigu.dao;

import com.hunguigu.vo.Role;
import com.hunguigu.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public List<User> query(User user);

    public User queryById(int id);

    public int queryTotal(User user);

    public int insert(User user);

    public int delete(int id);

    public int update(User user);

    public User userDengLu(User user);

    public List<Role> queryStaff_RoleBySid(int sid);

    //通过用户名查询用户信息
    public User queryUserName(String username);

    public List<String> queryRoleNameByUserName(String username);

    public List<String> queryMenuNameByUserName(String username);

    //选择提货商户
    public List<User> queryRole(int rid);

}