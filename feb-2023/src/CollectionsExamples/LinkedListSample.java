package CollectionsExamples;

import java.util.ArrayList;
import java.util.LinkedList;

/*
in the collections data type mentioned by below syntax
will not shift position after deletion of the elements
Good for adding and deletion the elements
diamond operataor <>
List<Object> obj = new ArrayList<Object>();
List<Object> obj = new ArrayList<Object>();+
 */
public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<Integer> ageList=  new LinkedList<Integer>();
        ageList.add(10);//0
        ageList.add(45);//1
        ageList.add(89);//2
        System.out.println(ageList.get(0));//get the value based on the index0
        System.out.println(ageList.get(1));
        LinkedList<String> nameList = new LinkedList<String>();
        nameList.add("test");
        nameList.add("test1");
        nameList.add("test2");

        for(Integer val:ageList){
            System.out.println(val);
        }
        System.out.println("--lambda expression--");
        //lambda expression.
        ageList.forEach((obj)->{
            System.out.println(obj);
        });
        System.out.println(nameList);//before adding
        nameList.add("adding new");
        nameList.add("adding new1");
        System.out.println(nameList);//after adding
        System.out.println("index "+nameList.indexOf("test2sdfds"));
        nameList.remove(0);//remove  based on the index
        nameList.remove("test1");//remove based on the object
        System.out.println(nameList);//after removing

    }
}
