package com.xsq.test;

import com.xsq.dao.impl.UserDaoImpl;
import com.xsq.pojo.User;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() throws SQLException {

        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
    }

    @Test
    public void saveUser() throws SQLException {
        System.out.println(userDao.saveUser(new User(null,"xsq","123456","812299454@qq.com")));
    }
}