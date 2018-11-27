package com.imooc.hsp.service.Impl;

import com.imooc.hsp.dao.DeptDao;
import com.imooc.hsp.entity.Dept;
import com.imooc.hsp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    public void add(Dept dept) {
        dept.setCreateTime(new Date());
        dept.setUpdateTime(new Date());
        deptDao.add(dept);
    }

    public void delete(Integer id) {
        deptDao.delete(id);
    }

    public void update(Dept dept) {
        dept.setUpdateTime(new Date());
        deptDao.update(dept);
    }

    public Dept select(Integer id) {
        return deptDao.select(id);
    }

    public List<Dept> selectAll() {
        return deptDao.selectAll();
    }

    public List<Dept> selectByCateId(Integer categoryId) {
        return deptDao.selectByCateId(categoryId);
    }

}
