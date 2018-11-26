package com.imooc.sm.controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.DepartmentService;
import com.imooc.sm.service.StaffService;
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

@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list = staffService.selectAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.selectAll();
        request.setAttribute("DLIST", list);
        request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(request.getParameter("did"));

        Staff staff = new Staff();
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        staff.setInfo(info);
        staff.setBornDate(bornDate);

        staffService.add(staff);

        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.select(id);
        request.setAttribute("OBJ", staff);
        List<Department> list = departmentService.selectAll();
        request.setAttribute("DLIST", list);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(request.getParameter("did"));

        Staff staff = staffService.select(id);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staffService.update(staff);

        response.sendRedirect("list.do");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.delete(id);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.select(id);
        request.setAttribute("OBJ", staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request, response);
    }
}
