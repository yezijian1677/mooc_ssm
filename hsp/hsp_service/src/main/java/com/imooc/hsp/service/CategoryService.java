package com.imooc.hsp.service;

import com.imooc.hsp.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    void delete(Integer id);
    void update(Category category);
    Category select(Integer id);
    List<Category> selectAll();
}
