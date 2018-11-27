package com.imooc.hsp.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getServletPath();
        if(path.indexOf("login")!= -1){
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("USER");
            if (obj!=null){
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect(request.getContextPath()+"/tologin.do");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
