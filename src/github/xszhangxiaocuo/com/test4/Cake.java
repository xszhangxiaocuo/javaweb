package github.xszhangxiaocuo.com.test4;

import java.util.Date;
import java.util.List;

public class Cake {
    private String id;
    private String name;
    private Date date;
    private List<String> material;

    public Cake(){

    }

    public Cake(String id,String name,Date date,List<String> material){
        this.id = id;
        this.name = name;
        this.date = date;
        this.material = material;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getMaterial() {
        return material;
    }

    public void setMaterial(List<String> material) {
        this.material = material;
    }
}
