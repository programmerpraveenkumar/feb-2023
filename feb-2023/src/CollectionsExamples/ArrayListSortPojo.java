package CollectionsExamples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSortPojo {
    public static void main(String[] args) {
        ArrayList<Person> objList = new ArrayList<Person>();
        Person person = new Person(1,"test");
        Person person1 = new Person(2,"tes2");
        Person person2 = new Person(3,"test3");
        objList.add(person2);
        objList.add(person);
        objList.add(person1);
        System.out.println(objList);
        objList.forEach(v->{
            System.out.println(v.getAge()+" "+v.getName());
        });
        System.out.println("---after sorting..----");
        Collections.sort(objList,new NameComparator());
        objList.forEach(v->{
            System.out.println(v.getAge()+" "+v.getName());
        });
    }
}
class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getAge()>p2.getAge()){
            return 1;
        }else if(p1.getAge() < p2.getAge()){
                return -1;
        }else {
            return 0;
        }
        //return 0;
    }
}