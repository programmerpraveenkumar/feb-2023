package CollectionsExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSortPojo2 {
    public static void main(String[] args) {
        ArrayList<Person1> objList = new ArrayList<Person1>();
        Person1 person = new Person1(1,"lion");
        Person1 person1 = new Person1(2,"cat");
        Person1 person2 = new Person1(3,"tiger");
        objList.add(person2);
        objList.add(person);
        objList.add(person1);
        System.out.println("--before sorting--");
        objList.forEach(v->{
            System.out.println(v.getAge()+" "+v.getName());
        });
        System.out.println("--after sorting--");
        //System.out.println(objList);
        Collections.sort(objList);//no need to call comparator method.PoJO is having the comparable interface
        objList.forEach(v->{
            System.out.println(v.getAge()+" "+v.getName());
        });


    }
}

