package com.imooc.sm.service.Impl;

import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    public void add(Staff staff) {
        staff.setPassword("123456");
        staff.setWorkTime(new Date());
        staff.setStatus("正常");
        staffDao.add(staff);
    }

    public void delete(int id) {
        staffDao.delete(id);
    }

    public void update(Staff staff) {
        staffDao.update(staff);
    }

    public Staff select(int id) {
        return staffDao.select(id);
    }

    public List<Staff> selectAll() {
        return staffDao.selectAll();
    }
}
