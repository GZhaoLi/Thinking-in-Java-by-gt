package com.gui.demo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Classname JdbcUtil
 * @Description 连接池工具类
 * @Date 2021/7/4 23:01
 * @Created by gt136
 */
public class JdbcUtils {

    private static String url;
    private static String user;
    private static String pwd;
    static {

        try {
            /*
             * 获取某个路径下文件的方式
             */
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            //此处返回的URL是统一资源定位符
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();

            Properties prop = new Properties();
            prop.load(new FileReader(path));
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            pwd = prop.getProperty("password");

            Class.forName(prop.getProperty("driver"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
    获取连接
     */
    public static Connection getConnection(String toUrl) throws SQLException {
        String url1 = url + toUrl;
        return DriverManager.getConnection(url1,user,pwd);
    }

    /*
    释放资源
     */
    public static void close(Statement stat, Connection conn) {
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
}