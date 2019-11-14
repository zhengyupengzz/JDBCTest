import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcConntionTest3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 2 .获取连接
        try {
            conn = DBUtil.getConnection();
            // 3.定义sql 获取sql执行环境
            String STUNAME = "";
            int STUAGE = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入姓名:");
            STUNAME = sc.next();
            System.out.println("请输入年龄:");
            STUAGE = sc.nextInt();
            String newsql = "insert into STUDENTS values ("
                    + "STUDENTS_STUID_SEQ.nextval,?,?)";
            ps = conn.prepareStatement(newsql);
            // 4.执行sql处理sql返回值
            ps.setString(1,STUNAME);
            ps.setInt(2,STUAGE);
            int rows = ps.executeUpdate();
            if (rows == 1){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 5.释放资源
            DBUtil.releaseResource(conn, ps, rs);
        }

    }
}

