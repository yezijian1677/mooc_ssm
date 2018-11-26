package com.imooc.sm.service;

import com.imooc.sm.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void delete(int id);
    void update(Department department);
    Department select(int id);
    List<Department> selectAll();

}
