package CollectionsExamples;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapArrayList {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String >> obj = new HashMap<String, ArrayList<String >>();

        ArrayList<String > obj1 = new ArrayList<>();
        obj1.add("test");
        obj1.add("test2");
        obj1.add("test3");
        obj1.add("test4");

        ArrayList<String > obj2 = new ArrayList<>();
        obj2.add("test");
        obj2.add("test2");
        obj2.add("test3");
        obj2.add("test4");

        ArrayList<String > obj3 = new ArrayList<>();
        obj3.add("test");
        obj3.add("test2");
        obj3.add("test3");
        obj3.add("test4");


        obj.put("test3",obj1);
        obj.put("test",obj2);
        obj.put("test1",obj3);

        obj.forEach((k,v)->{
            System.out.println(v);//arraylist
            v.forEach(val->{
                System.out.println(val);
            });
            System.out.println("--------");
        });
    }
}
