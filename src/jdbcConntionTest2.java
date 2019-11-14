import util.DBUtil;

import java.sql.*;
import java.util.Scanner;

public class jdbcConntionTest2 {
    public static void main(String[] args) {
                // 加载驱动
                
                // 定义三个变量
                Connection conn = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                // 2 .获取连接
                try {
                    conn = DBUtil.getConnection();
                    int stuid = -1;
                    // 3.定义sql 获取sql执行环境
                    Scanner sc = new Scanner(System.in);
                    System.out.println("请输入ID:");
                    stuid = sc.nextInt();
                    String newsql = "delete from STUDENTS where STUID = ?";
                    ps = conn.prepareStatement(newsql);
                    // 4.执行sql处理sql返回值
                    ps.setInt(1,stuid);
                    int rows = ps.executeUpdate();
                    if (rows == 1){
                        System.out.println("删除成功");
                    }else {
                        System.out.println("删除失败");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    // 5.释放资源
                    DBUtil.releaseResource(conn, ps, rs);
                }

            }
        }

