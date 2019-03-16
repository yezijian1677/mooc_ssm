package com.curtains.blog_jsp.controller;


import com.curtains.blog_jsp.entity.UserLoginInfo;
import com.curtains.blog_jsp.biz.Impl.UserLoginInfoServiceImpl;
import com.curtains.blog_jsp.biz.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

@Controller("loginController")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserLoginInfoServiceImpl userLoginInfoService;

    @RequestMapping(value = {"/admin/index", "/admin", "/admin/login"})
    public String toIndex(HttpServletRequest request){
//        System.out.println((request.getRealPath("/")));
        return "login";
    }


    /**
     * 三个状态 0 :用户不存在 1:密码错误 2:登录成功
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Object loginCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session){

        /**
         * 取出提交的 id 以及 password
         */
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        HashMap<String, String> result = new HashMap<String, String>();

        if (userService.getById(id) == null){
            result.put("status", "0");
        }
        else if (!userService.getById(id).getPassword().equals(password)){
            result.put("status", "1");
        }
        else {
            String ip = request.getRemoteAddr();
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.setIp(ip);
            userLoginInfo.setDate(new Date());
            userLoginInfo.setUserId(id);

            int log = userLoginInfoService.insert(userLoginInfo);

            session.setAttribute("user", userService.getById(id));

            result.put("status", "2");
        }

        return  result;

    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/admin/logout"})
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("user");
        return "redirect:/admin";
    }

}
