package CollectionsExamples;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListHashMap {
    public static void main(String[] args) {
        ArrayList<HashMap<String,String>> obj  = new ArrayList<HashMap<String,String>>();

        HashMap<String,String > obj1 = new HashMap<String,String>();
        obj1.put("test1","test1");
        obj1.put("test2","test2");
        obj1.put("test3","test3");

        HashMap<String,String > obj2 = new HashMap<String,String>();
        obj2.put("test1","test1");
        obj2.put("test2","test2");
        obj2.put("test3","test3");

        HashMap<String,String > obj3 = new HashMap<String,String>();
        obj3.put("test1","test1");
        obj3.put("test2","test2");
        obj3.put("test3","test3");

        obj.add(obj1);
        obj.add(obj2);
        obj.add(obj3);

        System.out.println(obj);

        obj.forEach(o->{
           // System.out.println(o);
            o.forEach((k,v)->{
                System.out.println(v);
            });
            System.out.println("---");
        });
    }
}
