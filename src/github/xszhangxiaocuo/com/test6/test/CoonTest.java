package github.xszhangxiaocuo.com.test6.test;

import github.xszhangxiaocuo.com.test6.domain.MysqlDBConn;

import java.sql.Connection;
import java.sql.SQLException;

public class CoonTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MysqlDBConn mysqldb = new MysqlDBConn();
        Connection conn = null;
        try {
            conn = mysqldb.getConnection();
            if (conn!=null){
                System.out.println("连接成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldb.close(null,conn);
        }


    }
}
