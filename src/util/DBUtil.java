package util;

import java.sql.*;

public class DBUtil {
    // 定义四个静态变量,保存连接数据库的信息
    private static String driverClassName="oracle.jdbc.OracleDriver";
    private static String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
    private static String username="system";
    private static String password="123456";
    static {
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
