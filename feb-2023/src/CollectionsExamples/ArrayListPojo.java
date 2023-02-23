package CollectionsExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*

 */
public class ArrayListPojo {
    public static void main(String[] args) {
        ArrayList<Person> personList =  new ArrayList<Person>();
        Person person1 = new Person(10,"person1");
        Person person2 = new Person(11,"person2");
        Person person3 = new Person(12,"person3");
        personList.add(person1);
        personList.add(new Person(45,"person4"));
        personList.add(person3);
        personList.add(person2);
        personList.forEach(obj->{
            System.out.println(obj.getAge()+" "+obj.getName());
        });

        List<Person> afterFilterList = personList.stream().filter(o->o.getAge()>20).collect(Collectors.toList());
        long filterCount = personList.stream().filter(o->o.getAge()>5).count();

       // pers
        System.out.println(filterCount);
        //System.out.println(afterFilterList.size());
//        personList.forEach(obj->{
//            System.out.println(obj.getAge()+" "+obj.getName());
//        });
        System.out.println("--after filter--");
        afterFilterList.forEach(obj->{
            System.out.println(obj.getAge()+" "+obj.getName());
        });
        List<String> ageonly = personList.stream().map(person -> person.getName()).collect(Collectors.toList());
        System.out.println(ageonly);
        //throw the error.as it is in custom object.
        //Collections.sort(personList);
        //
    }
}
