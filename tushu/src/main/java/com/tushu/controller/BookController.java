package com.tushu.controller;

import com.tushu.bean.Book;
import com.tushu.bean.Category;
import com.tushu.service.BookService;
import com.tushu.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller("bookController")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    private String receiveImage(HttpServletRequest request) {
        try{
            // 如果用户上传了这里代码是不会出现异常 了
            // 如果没有上传这里出现异常
            Part part = request.getPart("image");
            // 保存到项目的路径中去
            String sysPath = request.getSession().getServletContext().getRealPath("/img/book");
            // 定义一个新的图片名称
            String fileName = UUID.randomUUID().toString() ;
            //  提取图片的类型
            // 上传文件的内容性质
            String contentDispostion = part.getHeader("content-disposition");
            // 获取上传文件的后缀名
            String suffix = contentDispostion.substring(contentDispostion.lastIndexOf("."), contentDispostion.length() - 1);
            fileName+=suffix ;
            // 把图片保存到路径中去
            part.write(sysPath+"/"+fileName);
            return fileName ;
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }


    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list = bookService.selectAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../book_list.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.delete(id);
        response.sendRedirect("list.do");
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("CategoryList", categoryService.selectAll());
        request.getRequestDispatcher("../book_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("categoryId"));
        System.out.println(request.getParameter("level"));
        System.out.println(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int level = Integer.parseInt(request.getParameter("level"));
        int price = Integer.parseInt(request.getParameter("price"));
        String imgPath = receiveImage(request);

        Book book = new Book();
        book.setName(name);
        book.setCategoryId(categoryId);
        book.setLevel(level);
        book.setPrice(price);
        book.setImgPath(imgPath);
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        bookService.add(book);


        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.select(id);
        request.setAttribute("book", book);

        request.getRequestDispatcher("../book_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int level = Integer.parseInt(request.getParameter("level"));
        int price = Integer.parseInt(request.getParameter("price"));
        String imgPath = receiveImage(request);

        Book book = bookService.select(id);
        book.setName(name);
        book.setCategoryId(categoryId);
        book.setLevel(level);
        book.setPrice(price);
        book.setImgPath(imgPath);
        book.setUpdateTime(new Date());
        bookService.update(book);
        response.sendRedirect("list.do");
    }
}
