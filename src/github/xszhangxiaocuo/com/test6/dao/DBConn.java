package github.xszhangxiaocuo.com.test6.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DBConn {
    public Connection getConnection() throws SQLException, ClassNotFoundException;
    public void close(Statement stmt, Connection conn);
    public void close(ResultSet rs, Statement stmt, Connection conn);
}