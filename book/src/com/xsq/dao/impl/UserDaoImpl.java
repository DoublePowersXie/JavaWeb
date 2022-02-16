package com.xsq.dao.impl;

import com.xsq.dao.UserDao;
import com.xsq.pojo.User;

import java.sql.SQLException;

/**
 * @Description:
 * @Author: xsq  email:812299454@qq.com
 * @Date: 2022/1/26 - 20:01
 * @Version: 1.0
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) throws SQLException {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) throws SQLException {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
