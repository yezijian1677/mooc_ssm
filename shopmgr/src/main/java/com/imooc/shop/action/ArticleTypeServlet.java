package com.imooc.shop.action;

import com.imooc.shop.service.ShopService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleTypeServlet extends HttpServlet {

    private ShopService shopService;
    @Override
    public void init() throws ServletException{
        super.init();
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        shopService = (ShopService)context.getBean("shopService");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        super.service(request, response);
    }

}
