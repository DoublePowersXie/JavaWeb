package com.xsq.test;

import com.xsq.pojo.User;
import com.xsq.service.UserService;
import com.xsq.service.impl.UserServiceImpl;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() throws SQLException {
        userService.registUser(new User(null,"bbj","6666","asd@qq.com"));
    }

    @Test
    public void login() throws SQLException {
        System.out.println(userService.login(new User(null,"bbj","6666",null)));

    }

    @Test
    public void existsUsername() throws SQLException {
        if (userService.existsUsername("bbj")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}