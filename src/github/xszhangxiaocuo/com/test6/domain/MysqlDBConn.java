package github.xszhangxiaocuo.com.test6.domain;

import github.xszhangxiaocuo.com.test6.dao.DBConn;

import java.sql.*;

public class MysqlDBConn implements DBConn {
    public Connection getConnection() throws SQLException,ClassNotFoundException{
        //读取数据库连接配置文件
        PropertiesUtils.loadFile("github/xszhangxiaocuo/com/test6/jdbc.properties");
        String driver = PropertiesUtils.getPropertyValue("driver");
        String url = PropertiesUtils.getPropertyValue("url");
        String username = PropertiesUtils.getPropertyValue("username");
        String password = PropertiesUtils.getPropertyValue("password");
        Connection conn = null;
        try {
            //注册数据库驱动
            Class.forName(driver);
            //连接数据库
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(conn==null){
            System.out.println("conn is null!");
        }
        return conn;
    }

    public void close(Statement stmt,Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public void close(ResultSet rs, Statement stmt,Connection conn){
        if (rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }
        close(stmt,conn);
    }

}
