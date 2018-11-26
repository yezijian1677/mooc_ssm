package com.imooc.sm.service;

import com.imooc.sm.entity.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void delete(int id);
    void update(Staff staff);
    Staff select(int id);
    List<Staff> selectAll();
}
