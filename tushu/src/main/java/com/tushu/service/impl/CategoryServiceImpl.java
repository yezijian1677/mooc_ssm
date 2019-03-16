package com.tushu.service.impl;

import com.tushu.bean.Category;
import com.tushu.dao.CategoryDao;
import com.tushu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;


    @Override
    public Boolean add(Category category) {
        return categoryDao.add(category)>0;
    }

    @Override
    public int delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public Category select(int id) {
        return categoryDao.select(id);
    }

    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }
}
