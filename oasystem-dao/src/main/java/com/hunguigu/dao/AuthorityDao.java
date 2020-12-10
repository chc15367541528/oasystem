package com.hunguigu.dao;

import com.hunguigu.vo.Authority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityDao {

    public List<Authority> query(Authority authority);

    public Authority queryById(int id);

    public int queryTotal(Authority authority);

    public int insert(Authority authority);

    public int delete(int id);

    public int update(Authority authority);
}