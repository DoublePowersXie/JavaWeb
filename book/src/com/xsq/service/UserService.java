package com.xsq.service;

import com.xsq.pojo.User;

import java.sql.SQLException;

public interface UserService {
    /**
    *  注册用户
    * @param user
    * @return
    */
    public void registUser(User user) throws SQLException;

    /**
    *  登录
    * @param user
    * @return 如果返回null说明登录失败，返回有值则成功
    */
    public User login(User user) throws SQLException;

    /**
    *  检查用户名是否可用
    * @param username
    * @return 返回true表示用户已存在，返回false表示用户名可用
    */
    public boolean existsUsername(String username) throws SQLException;
}
