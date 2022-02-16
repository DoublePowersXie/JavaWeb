package com.xsq.test;

import com.xsq.utils.JdbcUtils;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @Description:
 * @Author: xsq  email:812299454@qq.com
 * @Date: 2022/1/25 - 17:50
 * @Version: 1.0
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() throws SQLException {
        System.out.println(JdbcUtils.getConnection());
    }
}
