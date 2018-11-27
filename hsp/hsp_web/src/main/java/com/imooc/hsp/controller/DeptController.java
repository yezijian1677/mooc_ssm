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

@Controller("deptController")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private CategoryService categoryService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dept> list = deptService.selectAll();
//        System.out.println(list.toString());
        request.setAttribute("depts", list);

        List<Category> cates = categoryService.selectAll();
        request.setAttribute("cates", cates);

        request.getRequestDispatcher("../dept_list.jsp").forward(request, response);
    }

    public void listByCateId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
        List<Dept> DEPT = deptService.selectByCateId(categoryId);
        System.out.println("this is  listId"+DEPT.toString());
        request.setAttribute("DEPTS", DEPT);

        List<Category> cates = categoryService.selectAll();
        request.setAttribute("cates", cates);

        request.getRequestDispatcher("../dept_listId.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> cates = categoryService.selectAll();
        request.setAttribute("cates", cates);
        request.getRequestDispatcher("../dept_add.jsp").forward(request, response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("name");

        Dept dept = new Dept();
        dept.setCategoryId(categoryId);
        dept.setName(name);
        deptService.add(dept);

        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Dept dept = deptService.select(id);
        request.setAttribute("dept", dept);
        List<Category> cates = categoryService.selectAll();
        request.setAttribute("cates", cates);
        request.getRequestDispatcher("../dept_edit.jsp").forward(request, response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("name");
        Date createTime = null;
        try {
            createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("createTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Dept dept = new Dept();
        dept.setId(id);
        dept.setCategoryId(categoryId);
        dept.setCreateTime(createTime);
        dept.setName(name);
        deptService.update(dept);

        response.sendRedirect("list.do");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        deptService.delete(id);
        response.sendRedirect("list.do");
    }

}
