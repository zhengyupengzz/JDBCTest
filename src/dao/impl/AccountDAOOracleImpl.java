package dao.impl;

import bean.Account;
import dao.AccountDAO;
import util.DBUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOOracleImpl implements AccountDAO {
    @Override
    public Account getAccountById(int STUID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            // 1.加载驱动 2.获取连接
            conn = DBUtil2.getConnection();
            // 3.定义sql 获取sql的执行环境
            String sql ="select * from STUDENTS where STUID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,STUID);
            // 4.执行sql 处理sql 返回值
            rs = ps.executeQuery();
            if (rs.next()){
                Account account = new Account();
                account.setSTUID(rs.getInt("STUID"));
                account.setSTUNAME(rs.getString("STUNAME"));
                account.setSTUAGE(rs.getInt("STUAGE"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // 5.释放资源
            DBUtil2.releaseResource(conn,ps,rs);
        }
        return null;
    }

    @Override
    public Account getAccountByNameAndAge(String STUNAME , int STUAGE) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            // 1.加载驱动 2.获取连接
            conn = DBUtil2.getConnection();
            // 3.定义sql 获取sql执行环境
            String sql = "select * from STUDENTS where STUNAME =? " +
                    "and STUAGE =?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1,STUNAME);
            ps.setInt(2,STUAGE);
            // 4.执行sql 处理sql的返回值
            rs = ps.executeQuery();
            if (rs.next()){
                Account account = new Account(rs.getInt("STUID"),
                        rs.getString("STUNAME"),rs.getInt("STUAGE"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 5.释放资源
            DBUtil2.releaseResource(conn,ps,rs);
        }
        return null;
    }
}
