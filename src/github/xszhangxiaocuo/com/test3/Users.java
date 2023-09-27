package github.xszhangxiaocuo.com.test3;

import java.util.HashMap;

public class Users{
    private static HashMap<String,User> users = new HashMap<>();

    public static void addUser(String username,String password){
        users.put(username,new User(username,password));
    }

    public static void delUser(String username){
        users.remove(username);
    }

    public static User getUser(String username){
        return users.get(username);
    }

}

class User {
    private String name;
    private String password;


    public User(String name,String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
