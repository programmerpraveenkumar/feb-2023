package CollectionsExamples.SetSample;

import CollectionsExamples.Person1;

import java.util.TreeSet;

/*
will not allow for the duplicates
it will not maintain the insertion order
it will maintain the ascending order.
 */
public class TreeSetPojo {
    public static void main(String[] args) {
        TreeSet<Person1> obj = new TreeSet<Person1>();
        Person1 person = new Person1(1,"lion");
        Person1 person1 = new Person1(2,"cat");
        Person1 person2 = new Person1(3,"tiger");

        obj.add(person1);
        obj.add(person);
        obj.add(person2);

        obj.forEach((o)->{
            System.out.println(o.getAge()+" "+o.getName());
        });
//        System.out.println(obj);

    }
}
