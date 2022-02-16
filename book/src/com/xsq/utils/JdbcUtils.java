package com.xsq.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description: 用于连接和关闭数据库
 * @Author: xsq  email:812299454@qq.com
 * @Date: 2022/1/25 - 17:17
 * @Version: 1.0
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;

    static {

        try {
            Properties properties = new Properties();
            //读取jdbc.properties配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //读取流数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
    * 获取数据库连接池中的连接
    * @Author: xsq  email:812299454@qq.com
    * @Date 2022/1/25 - 17:20
    */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = dataSource.getConnection();
        return conn;
    }

    /**
    * @Description: //TODO 关闭连接，放回数据库连接池
    * @Author: xsq  email:812299454@qq.com
    * @Date 2022/1/25 - 17:22
    */
    public static void close(Connection conn) throws SQLException {
        if (conn != null){
            conn.close();
        }
    }
}
