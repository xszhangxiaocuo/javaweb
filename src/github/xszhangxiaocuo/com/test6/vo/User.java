package github.xszhangxiaocuo.com.test6.vo;

import java.sql.Date;

public class User {
    private String sno;
    private String sname;
    private String passwd;
    private Date birthday;

    public User(){

    }
    public User(String sno,String sname,String passwd,Date birthday){
        this.sno = sno;
        this.sname = sname;
        this.passwd = passwd;
        this.birthday = birthday;
    }
    public String getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public String getPasswd() {
        return passwd;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
