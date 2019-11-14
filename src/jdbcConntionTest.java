import util.DBUtil2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConntionTest {
    public static void main(String[] args) {
      
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        // 2 .获取连接
        try {
            conn = DBUtil2.getConnection();
            System.out.println(conn);
            // 3.定义sql 获取sql执行环境
            String sql = "select * from STUDENTS";
            st = conn.createStatement();
            // 4.执行sql处理sql返回值
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getInt("STUID")+":"+rs.getString("STUNAME")
                        +" "+rs.getInt("STUAGE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 5.释放资源
            DBUtil2.releaseResource(conn, st, rs);
        }

    }
}
