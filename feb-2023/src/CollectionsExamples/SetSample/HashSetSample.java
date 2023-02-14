package CollectionsExamples.SetSample;

import java.util.HashSet;
/*
   will not allow the duplicates
   will not maintain the insertion order.
 */
public class HashSetSample {
    public static void main(String[] args) {
        HashSet<String> obj = new HashSet<>();
        obj.add("test");
        obj.add("test1");
        obj.add("test2");
        obj.add("test");//this will be ignored as it is not accepts the duplicates
        obj.add("test3");
        System.out.println(obj);
        obj.forEach((val)->{
            System.out.println(val);
        });
    }
}
