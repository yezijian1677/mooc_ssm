package com.imooc.hsp.service.Impl;

import com.imooc.hsp.dao.CategoryDao;
import com.imooc.hsp.entity.Category;
import com.imooc.hsp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public void add(Category category) {
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        categoryDao.add(category);
    }

    public void delete(Integer id) {
        categoryDao.delete(id);
    }

    public void update(Category category) {
        category.setUpdateTime(new Date());
        categoryDao.update(category);
    }

    public Category select(Integer id) {
        return categoryDao.select(id);
    }

    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }
}
