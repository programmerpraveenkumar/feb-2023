package CollectionsExamples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSortPojo {
    public static void main(String[] args) {
        ArrayList<Person> objList = new ArrayList<Person>();
        Person person = new Person(1,"lion");
        Person person1 = new Person(2,"cat");
        Person person2 = new Person(3,"tiger");
        objList.add(person2);
        objList.add(person);
        objList.add(person1);
        System.out.println(objList);
        objList.forEach(v->{
            System.out.println(v.getAge()+" "+v.getName());
        });
        System.out.println("---after sorting - Name ..----");
        Collections.sort(objList,new NameComparator());
        objList.forEach(v->{
            System.out.println(v.getAge()+" "+v.getName());
        });
        System.out.println("---after sorting - Age ..----");
        Collections.sort(objList,new AgeComparator());
        objList.forEach(v->{
            System.out.println(v.getAge()+" "+v.getName());
        });
    }
}
class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(),p2.getAge());//returns int
//        if(p1.getAge()>p2.getAge()){
//            return 1;//1nd argument is bigger than 2nd
//        }else if(p1.getAge() < p2.getAge()){
//            return -1;//2nd argument is bigger than 1st
//        }else {
//            return 0;//both are same
//        }
        //return 0;
    }
}