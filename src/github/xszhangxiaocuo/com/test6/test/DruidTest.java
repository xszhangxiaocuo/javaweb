package github.xszhangxiaocuo.com.test6.test;

import github.xszhangxiaocuo.com.test6.domain.DruidUtils;

import java.sql.Connection;

public class DruidTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
           conn = DruidUtils.getConnection();
           if (conn!=null){
               System.out.println("连接成功！");
               return;
           }
            System.out.println("连接失败！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DruidUtils.close(null,conn);
        }
    }
}
