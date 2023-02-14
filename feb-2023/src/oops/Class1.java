package oops;
/*
inheritance->
    inherit the props from another class
    private variables or methods cannot inherit
 */
public class Class1 extends Class2 implements AnimalInterface2 {
    @Override//overriding the method from the parent class
   public void printName(String name){
        System.out.println("Name is(child class) "+this.name+name);
    }
    public static void main(String[] args) {
        Class1 cls = new Class1();//creation object for class1
       // cls.number = 45;//private members cant access from the parent class
        cls.name = "sample name";//coming from the parent class
        cls.printNumber();//calling from the parent class
        cls.printName("args");//calling from the child class

        Class2 obj = new Class2();
        obj.name="to parent class";
        obj.printName("some name");//it class from the parent clss
    }



    @Override
    public void printAnimalName() {

    }
}