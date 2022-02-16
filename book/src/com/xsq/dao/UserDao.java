package com.xsq.dao;

import com.xsq.pojo.User;

import java.sql.SQLException;

public interface UserDao {



    /**
    *  根据用户名查询用户信息
    * @param username 用户名
    * @return 返回null说明该用户还未被注册，反之亦然
    */
    public User queryUserByUsername(String username) throws SQLException;

    /**
    * @Description: //TODO: 根据用户名和密码查询用户信息
    * @param username
    * @param password
    * @return 如果返回null,说明用户名和密码错误，反之亦然
    */
    public User queryUserByUsernameAndPassword(String username,String password) throws SQLException;

    /**
    * @Description: //TODO: 保存用户信息
    * @param user
    * @return
    */
    public int saveUser(User user) throws SQLException;
}
