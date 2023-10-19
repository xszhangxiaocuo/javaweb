package github.xszhangxiaocuo.com.test6.test;

import github.xszhangxiaocuo.com.test6.domain.DBUtils;
import github.xszhangxiaocuo.com.test6.vo.User;

import java.sql.Date;

public class InsertTest {
    public static void main(String[] args) {
        DBUtils dbu = new DBUtils();
        try {
            if (dbu.insert(new User("5","张小搓","132",new Date(2023-1900,1,1)))){
                System.out.println("插入成功");
                return;
            }
            System.out.println("插入失败！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
