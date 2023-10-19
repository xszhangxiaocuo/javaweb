package github.xszhangxiaocuo.com.test6.domain;

import github.xszhangxiaocuo.com.test6.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUtils {
    private MysqlDBConn mysqldb = null;
    private Connection conn = null;
    private PreparedStatement preStmt = null;
    private ResultSet rs = null;
    public DBUtils(){
        mysqldb = new MysqlDBConn();
    }
    //增加一条记录
    public boolean insert(User user){
        try {
            //获取一个数据库连接
            conn = mysqldb.getConnection();
            String sql = "INSERT INTO user(sno,sname,passwd,birthday)" +
                    "VALUE(?,?,?,?)";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,user.getSno());
            preStmt.setString(2,user.getSname());
            preStmt.setString(3,user.getPasswd());
            preStmt.setDate(4,user.getBirthday());
            int row = preStmt.executeUpdate();
            if (row>0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldb.close(rs,preStmt,conn);
        }
        return false;
    }

    //查询所有User记录
    public ArrayList<User> findAll(){
        try {
            conn = mysqldb.getConnection();
            String sql = "select * from user";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            ArrayList<User> result = new ArrayList<>();
            while (rs.next()){
                User user = readRS();
                result.add(user);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldb.close(rs,preStmt,conn);
        }
        return null;
    }

    //根据sno查找记录
    public User find(String sno){
        try {
            conn = mysqldb.getConnection();
            String sql = "select * from user where sno=?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,sno);
            rs = preStmt.executeQuery();
            while (rs.next()){
                return readRS();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldb.close(rs,preStmt,conn);
        }
        return null;
    }

    //根据sno删除记录
    public boolean delete(String sno){
        try {
            conn = mysqldb.getConnection();
            String sql = "delete from user where sno=?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,sno);
            int row = preStmt.executeUpdate();
            if (row>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldb.close(rs,preStmt,conn);
        }
        return false;
    }

    //修改记录
    public boolean update(User user){
        try {
            conn = mysqldb.getConnection();
            String sql = "update user set sname=?,passwd=?,birthday=? where sno=?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,user.getSname());
            preStmt.setString(2,user.getPasswd());
            preStmt.setDate(3,user.getBirthday());
            preStmt.setString(4,user.getSno());
            int row = preStmt.executeUpdate();
            if (row>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldb.close(rs,preStmt,conn);
        }
        return false;
    }

    private User readRS() throws SQLException {
        User user = new User();
        user.setSno(rs.getString("sno"));
        user.setSname(rs.getString("sname"));
        user.setPasswd(rs.getString("passwd"));
        user.setBirthday(rs.getDate("birthday"));
        return user;
    }
}
