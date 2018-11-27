package com.imooc.hsp.service;

import com.imooc.hsp.entity.Dept;

import java.util.List;

public interface DeptService {
    void add(Dept dept);
    void delete(Integer id);
    void update(Dept dept);
    Dept select(Integer id);
    List<Dept> selectAll();
    List<Dept> selectByCateId(Integer categoryId);
}
