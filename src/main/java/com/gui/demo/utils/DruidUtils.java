package com.gui.demo.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Classname DruidUtils
 * @Description druid工具类
 * @Date 2021/7/6 23:18
 * @Created by gt136
 */
public class DruidUtils {
    //1.定义成员变量 DataSource
    private static DataSource ds;
    //2.静态代码
    static {
        try {
            Properties prop = new Properties();
            prop.load(DruidUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3.获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //4.释放资源
    public static void close(Statement stat, Connection conn) {
        close(null,stat,conn);
    }

    public static void close(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //5.获取连接池方法
    public static DataSource getDs() {
        return ds;
    }
}
