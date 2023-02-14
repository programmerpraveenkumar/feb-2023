package CollectionsExamples.MapSample;

import java.util.HashMap;
import java.util.TreeMap;

/*
treemap
    key and value will be stored
    key should not be duplicated
    it will not maintain insertion order.but it will sort the key
 */
public class TreeMapSample {
    public static void main(String[] args) {
        TreeMap<Integer,String> obj = new TreeMap<Integer,String>();
        obj.put(1,"test");//add the value
        obj.put(4,"asdfds");
        obj.put(3,"test2");
        obj.put(2,"test1");

        System.out.println(obj.get(1));//access the value using key
        System.out.println(obj.remove(2));
        System.out.println(obj);
        obj.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
        obj.put(5,"asdfds");
        obj.put(3,"test3");//previous value will be override
        System.out.println(obj);
    }
}
