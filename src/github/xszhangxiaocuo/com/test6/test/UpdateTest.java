package github.xszhangxiaocuo.com.test6.test;

import github.xszhangxiaocuo.com.test6.domain.DBUtils;
import github.xszhangxiaocuo.com.test6.vo.User;

import java.sql.Date;

public class UpdateTest {
    public static void main(String[] args) {
        DBUtils dbu = new DBUtils();
        try {
            if (dbu.update(new User("4","张小搓","132",new Date(2023-1900,0,1)))){
                System.out.println("更新成功！");
            }
            if (dbu.delete("5")){
                System.out.println("删除成功！");
                return;
            }
            System.out.println("更新失败！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
