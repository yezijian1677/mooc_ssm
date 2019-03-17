package com.tushu.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tushu.bean.Book;
import com.tushu.bean.Category;
import com.tushu.service.BookService;
import com.tushu.service.CategoryService;

import com.tushu.util.Imageutil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller("bookController")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;


    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list = bookService.selectAll();
        request.setAttribute("LIST", list);
        request.setAttribute("CategoryList", categoryService.selectAll());
        request.getRequestDispatcher("../book_list.jsp").forward(request, response);
    }

    public void listByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Book> list = bookService.selectByCategoryId(id);
        request.setAttribute("LIST", list);
        request.setAttribute("CategoryList", categoryService.selectAll());
        request.getRequestDispatcher("../book_list.jsp").forward(request, response);
    }

    public void flist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  page1 = request.getParameter("page");
        int page = 0;
        if (page1 == null){
            page = 1;
        }else {
            page = Integer.parseInt(page1);
        }
        int pageSize = 8;
        PageHelper.startPage(page, pageSize); //开始起始页

        List<Book> list = bookService.selectAll();
        PageInfo<Book> p = new PageInfo<Book>(list);
        request.setAttribute("page", p); // 设置属性到前端页面
        request.setAttribute("LIST", list);
        request.setAttribute("CategoryList", categoryService.selectAll());
        request.getRequestDispatcher("../book_flist.jsp").forward(request, response);
    }

    public void flistByCategoryId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  page1 = request.getParameter("page");
        int page = 0;
        if (page1 == null){
            page = 1;
        }else {
            page = Integer.parseInt(page1);
        }
        int pageSize = 8;
        PageHelper.startPage(page, pageSize); //开始起始页


        int id = Integer.parseInt(request.getParameter("id"));
        List<Book> list = bookService.selectByCategoryId(id);
        PageInfo<Book> p = new PageInfo<Book>(list);
        request.setAttribute("page", p); // 设置属性到前端页面





        request.setAttribute("LIST", list);
        request.setAttribute("CategoryList", categoryService.selectAll());
        request.getRequestDispatcher("../book_flistByCategoryId.jsp").forward(request, response);
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
        Map<String,String> params = new HashMap<>();
        InputStream is = Imageutil.parseUpload(request, params);

        String name = params.get("name");
        int categoryId = Integer.parseInt(params.get("categoryId"));
        int level = Integer.parseInt(params.get("level"));
        int price = Integer.parseInt(params.get("price"));


        File imageFolder= new File(request.getSession().getServletContext().getRealPath("img/book"));
        File file = new File(imageFolder,UUID.randomUUID()+".jpg");
        file.getParentFile().mkdirs();
        try {
            if(null!=is && 0!=is.available()){
                try(FileOutputStream fos = new FileOutputStream(file)){
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.flush();
                    //通过如下代码，把文件保存为jpg格式
                    BufferedImage img = Imageutil.change2jpg(file);
                    ImageIO.write(img, "jpg", file);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String imgPath = file.getCanonicalPath();

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
        request.setAttribute("CategoryList", categoryService.selectAll());
        request.getRequestDispatcher("../book_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> params = new HashMap<>();
        InputStream is = Imageutil.parseUpload(request, params);
        int id = Integer.parseInt(params.get("id"));
        String name = params.get("name");
        int categoryId = Integer.parseInt(params.get("categoryId"));
        int level = Integer.parseInt(params.get("level"));
        int price = Integer.parseInt(params.get("price"));

        File imageFolder= new File(request.getSession().getServletContext().getRealPath("img/book"));
        File file = new File(imageFolder,UUID.randomUUID()+".jpg");
        file.getParentFile().mkdirs();
        try {
            if(null!=is && 0!=is.available()){
                try(FileOutputStream fos = new FileOutputStream(file)){
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.flush();
                    //通过如下代码，把文件保存为jpg格式
                    BufferedImage img = Imageutil.change2jpg(file);
                    ImageIO.write(img, "jpg", file);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String imgPath = file.getCanonicalPath();

        Book book = bookService.select(id);
        book.setName(name);
        book.setCategoryId(categoryId);
        book.setLevel(level);
        book.setPrice(price);
        if (imgPath!=null){
            book.setImgPath(imgPath);
        }
        book.setUpdateTime(new Date());
        bookService.update(book);
        response.sendRedirect("list.do");
    }
}
