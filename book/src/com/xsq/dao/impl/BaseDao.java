package com.xsq.dao.impl;

import com.xsq.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description: 抽象类
 * @Author: xsq  email:812299454@qq.com
 * @Date: 2022/1/26 - 11:56
 * @Version: 1.0
 */
public abstract class BaseDao {
    //使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
    * @Description: //TODO: 用于执行：Insert\Update\Delete语句
    * @Date 2022/1/26 - 12:29
    * @return 返回-1执行失败，返回其他表示影响的行数
    */
    public int update(String sql,Object ...args) throws SQLException {
        //获取数据库连接
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
    * @Description: //TODO: 执行select查询语句,返回一个对象
    * @Date 2022/1/26 - 18:47
    * @return
    */
    public <T> T queryForOne(Class<T> type, String sql,Object ... args) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    /**
    * @Description: //TODO:查询返回多个javaBean语句
    * @Date 2022/1/26 - 18:59
    * @return
    */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    /**
    * @Description: //TODO: 查询返回一行一列
    * @Date 2022/1/26 - 19:25
    * @return
    */
    public Object queryForSingleValue(String sql,Object ... args) throws SQLException {
        Connection con = JdbcUtils.getConnection();

        try {
            return queryRunner.query(con,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(con);
        }
        return null;
    }
}
