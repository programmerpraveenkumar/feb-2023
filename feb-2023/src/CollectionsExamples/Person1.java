package CollectionsExamples;

import java.util.Comparator;

public class Person1 implements Comparable<Person1>{
    public Person1(int age, String name) {
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


    @Override
    public int compareTo(Person1 o) {
        return Integer.compare(this.getAge(),o.getAge());//returns int
    }


}
