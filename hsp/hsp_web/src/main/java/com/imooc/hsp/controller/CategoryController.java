package com.imooc.hsp.controller;

import com.imooc.hsp.entity.Category;
import com.imooc.hsp.entity.Dept;
import com.imooc.hsp.service.CategoryService;
import com.imooc.hsp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("categoryController")
public class CategoryController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private CategoryService categoryService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.selectAll();
        System.out.println(list.toString());
        request.setAttribute("cates", list);
        request.getRequestDispatcher("../category_list.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../category_add.jsp").forward(request, response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Category category = new Category();
        category.setName(name);
        categoryService.add(category);

        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.select(id);
        request.setAttribute("cate", category);
        request.getRequestDispatcher("../category_edit.jsp").forward(request, response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date createTime = null;
        try {
            createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("createTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Category category = new Category();
        category.setId(id);
        category.setCreateTime(createTime);
        category.setName(name);
        categoryService.update(category);

        response.sendRedirect("list.do");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(id);
        response.sendRedirect("list.do");
    }

}
