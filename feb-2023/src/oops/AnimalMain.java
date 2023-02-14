package oops;

public class AnimalMain {
    public static void main(String[] args) {
        Animal lion = new Animal("Lion",10);
//        lion.setAge(10);//setter method to set the value
//        lion.setName("Lion");
        System.out.println(lion.getAge());//get method to get the value
        System.out.println(lion.getName());

        Animal tiger = new Animal();
        tiger.setAge(15);
        tiger.setName("tiger");
        System.out.println(tiger.getAge());
        System.out.println(tiger.getName());
    }
}
