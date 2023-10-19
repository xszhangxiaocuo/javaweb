package github.xszhangxiaocuo.com.test6.test;

import github.xszhangxiaocuo.com.test6.domain.DBUtils;
import github.xszhangxiaocuo.com.test6.vo.User;

import java.util.ArrayList;

public class FindAllTest {
    public static void main(String[] args) {
        DBUtils dbu = new DBUtils();
        try {
            ArrayList<User> list = dbu.findAll();
            System.out.println("查询所有记录：");
            for (int i = 0; i < list.size(); i++) {
                User user = list.get(i);
                System.out.printf("%s\t|%s\t|%s\t|%s\n",user.getSno(),user.getSname(),user.getPasswd(),user.getBirthday().toString());
            }
            System.out.println("根据sno查询：");
            User user = dbu.find("1");
            System.out.printf("%s\t|%s\t|%s\t|%s\n",user.getSno(),user.getSname(),user.getPasswd(),user.getBirthday().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
