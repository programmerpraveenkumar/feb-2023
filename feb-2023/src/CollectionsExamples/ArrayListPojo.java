package CollectionsExamples;

import java.util.ArrayList;

/*

 */
public class ArrayListPojo {
    public static void main(String[] args) {
        ArrayList<Person> personList =  new ArrayList<Person>();
        Person person1 = new Person(10,"person1");
        Person person2 = new Person(11,"person2");
        Person person3 = new Person(12,"person3");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(new Person(45,"person4"));
        personList.forEach(obj->{
            System.out.println(obj.getAge()+" "+obj.getName());
        });
    }
}
class Person{
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}