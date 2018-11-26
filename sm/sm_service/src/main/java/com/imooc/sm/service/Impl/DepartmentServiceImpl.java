package com.imooc.sm.service.Impl;

import com.imooc.sm.dao.DepartmentDao;
import com.imooc.sm.entity.Department;
import com.imooc.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.add(department);
    }

    public void delete(int id) {
        departmentDao.delete(id);
    }

    public void update(Department department) {
        departmentDao.update(department);
    }

    public Department select(int id) {
        return departmentDao.select(id);
    }

    public List<Department> selectAll() {
        return departmentDao.selectAll();
    }
}
