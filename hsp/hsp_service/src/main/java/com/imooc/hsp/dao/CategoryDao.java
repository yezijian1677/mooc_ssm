package com.imooc.hsp.dao;

import com.imooc.hsp.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public interface CategoryDao {
    void add(Category category);
    void delete(Integer id);
    void update(Category category);
    Category select(Integer id);
    List<Category> selectAll();
}
