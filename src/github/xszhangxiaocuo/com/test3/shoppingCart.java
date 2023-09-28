package github.xszhangxiaocuo.com.test3;

import java.util.HashMap;
import java.util.Map;

public class shoppingCart {
    private  Map<String,Integer> items = new HashMap<String,Integer>();
    private int number;

    public static String[] itemNames = {" JAVA程序设计","人工智能概述","编译原理","设计模式","大道至简"};

    public Map<String, Integer> getItems() {
        return items;
    }

    public int getNumber() {
        return number;
    }

   public void addItem(String... book){
       for (String s : book) {
           if (items.get(s)==null) {
               items.put(s, 1);
           }else {
               items.put(s, items.get(s)+1);
           }
           number++;
       }
   }
}
