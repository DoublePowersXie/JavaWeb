package com.xsq.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xsq.dao.UserDao;
import com.xsq.dao.impl.UserDaoImpl;
import com.xsq.pojo.User;
import com.xsq.service.UserService;

import java.sql.SQLException;

/**
 * @Description:
 * @Author: xsq  email:812299454@qq.com
 * @Date: 2022/1/26 - 21:55
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao =  new UserDaoImpl();

    @Override
    public void registUser(User user) throws SQLException {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) throws SQLException {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) throws SQLException {
        if (userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
