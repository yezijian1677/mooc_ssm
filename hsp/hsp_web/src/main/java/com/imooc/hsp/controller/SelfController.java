package com.imooc.hsp.controller;

import com.imooc.hsp.entity.User;
import com.imooc.hsp.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("selfController")
public class SelfController {
    @Autowired
    private SelfService selfService;

    public void tologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = selfService.login(username, password);
        if (user == null){
            response.sendRedirect("toLogin.do");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("USER", user);
            response.sendRedirect("main.do");
        }

    }

    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("USER", null);
        response.sendRedirect("toLogin.do");

    }
}
