package CollectionsExamples.SetSample;

import java.util.LinkedHashSet;
/*
   will not allow the duplicates
   will maintain the insertion order.
 */
public class LinkedHashSetSample {
    public static void main(String[] args) {
        LinkedHashSet<String> list = new LinkedHashSet<>();
        list.add("test");
        list.add("test1");
        list.add("test2");
        list.add("test");//this will be ignored as it is not accepts the duplicates
        list.add("test3");
        System.out.println(list);
        list.forEach((val)->{
            System.out.println(val);
        });

        //LinkedHashSet with Integer
        LinkedHashSet<Integer> listInt = new LinkedHashSet<Integer>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        System.out.println(listInt);


    }
}
