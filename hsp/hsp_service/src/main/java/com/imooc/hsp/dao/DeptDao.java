package com.imooc.hsp.dao;

import com.imooc.hsp.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deptDao")
public interface DeptDao {
    void add(Dept dept);
    void delete(Integer id);
    void update(Dept dept);
    Dept select(Integer id);
    List<Dept> selectAll();
    List<Dept> selectByCateId(Integer categoryId);
}
