package CollectionsExamples.MapSample;

import CollectionsExamples.Person;

import java.util.HashMap;

public class HashMapPojo {
    public static void main(String[] args) {
        HashMap<String, Person> mapObj = new HashMap<String,Person>();
        Person person1 = new Person(1,"test");
        Person person2 = new Person(2,"test2");
        Person person3 = new Person(3,"test3");
        mapObj.put("test",person1);
        mapObj.put("test2",person2);
        mapObj.put("test3",person3);
        System.out.println(mapObj);
        mapObj.forEach((key,obj)->{
            System.out.println(obj.getAge()+" "+obj.getName());
        });
    }
}
