package com.tushu.service;

import com.tushu.bean.Category;

import java.util.List;

public interface CategoryService {
    Boolean add(Category category);
    int delete(int id);
    int update(Category category);
    Category select(int id);
    List<Category> selectAll();
}
