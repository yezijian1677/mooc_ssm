package com.tushu.dao;

import com.tushu.bean.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public interface CategoryDao {
    int add(Category category);
    int delete(int id);
    int update(Category category);
    Category select(int id);
    List<Category> selectAll();
}
