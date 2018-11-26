package com.damu.servlet;

import com.damu.dao.UsersDAO;
import com.damu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class UsersFindByIdServlet extends HttpServlet {
    private UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
//        System.out.println(id);

        Users user = usersDAO.findById(Integer.parseInt(id));

        req.setAttribute("user", user);

        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }
}
