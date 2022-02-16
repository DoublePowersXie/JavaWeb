package com.xsq.web;

import com.xsq.pojo.User;
import com.xsq.service.UserService;
import com.xsq.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: xsq  email:812299454@qq.com
 * @Date: 2022/1/27 - 12:24
 * @Version: 1.0
 */
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User loginUser = userService.login(new User(null,username,password,null));
            if (loginUser == null){
                //登录失败
                req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
            }else{
                //登录成功
                req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}
