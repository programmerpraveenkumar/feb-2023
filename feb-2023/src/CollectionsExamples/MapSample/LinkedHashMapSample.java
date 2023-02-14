package CollectionsExamples.MapSample;

import java.util.LinkedHashMap;
import java.util.TreeMap;
/*
treemap
    key and value will be stored
    key should not be duplicated
    it will  maintain insertion order
 */
public class LinkedHashMapSample {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> obj = new LinkedHashMap<Integer,String>();
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
