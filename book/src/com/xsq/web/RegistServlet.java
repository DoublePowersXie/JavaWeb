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

public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查验证码是否正确，先写死，要求验证码为：bcde
        if("abcde".equalsIgnoreCase(code)){
            //正确
            //3.检查用户名是否可用
            try {
                if (userService.existsUsername(username)){
                    System.out.println("用户名[" + username + "]已存在！");
                    //跳转注册页面
                    req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
                }else {
                    //用户名可用,调用Service保存到数据库
                    userService.registUser(new User(null,username,password,email));
                    //跳转到注册成功页面
                    System.out.println("123456");
                    req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //验证码不正确
        else{
            System.out.println("验证码[" + code + "]错误！");
            //跳转注册页面
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
