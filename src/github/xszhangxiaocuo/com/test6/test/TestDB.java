package github.xszhangxiaocuo.com.test6.test;

import java.sql.*;

public class TestDB {
    public static void main(String[] args) throws SQLException {
        Statement stmt=null;
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            //注册数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //通过DriveManger获取数据库连接
            String url = "jdbc:mysql://localhost:3306/jdbctest?serverTimezone=GMT%2B8";
            String username="root";
            String password = "kankan123";
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("MySql数据库连接成功！");
            //通过Connection对象获取Statement对象
            stmt = conn.createStatement();
            //使用Statement对象执行SQL语句
            String sql = "select * from user";
            rs = stmt.executeQuery(sql);
            //操作ResultSet结果集
            System.out.println("sno\t|sname\t|passwd\t|birthday");
            while (rs.next()){
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String passwd = rs.getString("passwd");
                Date birthday = rs.getDate("birthday");
                System.out.printf("%s\t|%s\t|%s\t|%s\n",sno,sname,passwd,birthday.toString());
            }

            //向数据库中插入一条记录
            sql = "INSERT INTO user(sno,sname,passwd,birthday)"+"VALUES (?,?,?,?)";
            //创建执行sql语句的PreparedStatement对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,"3");
            preStmt.setString(2,"王五");
            preStmt.setString(3,"123");
            preStmt.setDate(4,new Date(2023,10,10));
            preStmt.executeUpdate();
            System.out.println("向student中插入了一条数据");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //回收数据库资源
            if (rs!=null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                rs=null;
            }
            if (stmt!=null){
                try {
                    stmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (preStmt!=null){
                try {
                    preStmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                preStmt = null;
            }
            if (conn!=null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
