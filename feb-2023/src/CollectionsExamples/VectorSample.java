package CollectionsExamples;

import java.util.ArrayList;
import java.util.Vector;

/*
in the collections data type mentioned by below syntax
diamond operataor <>
List<Object> obj = new ArrayList<Object>();
List<Object> obj = new ArrayList<Object>();
can be used in thread.so it is slower than arraylist
 */
public class VectorSample {
    public static void main(String[] args) {
        Vector<Integer> ageList=  new Vector<>();
        ageList.add(10);//0
        ageList.add(45);//1
        ageList.add(89);//2
        System.out.println(ageList.get(0));//get the value based on the index0
        System.out.println(ageList.get(1));
        ArrayList<String> nameList = new ArrayList<String>();
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
