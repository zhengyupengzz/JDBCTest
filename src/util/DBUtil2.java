package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil2 {
    // 定义四个静态变量,保存连接数据库的信息
    private static String driverClassName;
    private static String url;
    private static String username;
    private static String password;
    static {
        // 读取src下的db.properties 给上面的四个静态成员变量赋值 
        // 使用类加载器 读取src下的db.properties
        InputStream inputStream =
        DBUtil2.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro = new Properties();
        // 加载流中的key value
        try {
            pro.load(inputStream);
            // 可以从pro中取出key 对应的值
            driverClassName = pro.getProperty("driverClassName");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 提供静态方法,完成获取数据库链接 
    public  static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    // 释放资源
    public static void releaseResource(Connection conn, Statement st, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
