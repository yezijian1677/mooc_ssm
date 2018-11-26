package com.imooc.sm.dao;

import com.imooc.sm.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void add(Department department);
    void delete(int id);
    void update(Department department);
    Department select(int id);
    List<Department> selectAll();

}
