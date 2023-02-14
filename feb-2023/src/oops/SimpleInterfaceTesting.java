package oops;

public class SimpleInterfaceTesting {
    public static void main(String[] args) {
        AnimalInterface2 animalInterface2 = new Lion();//can create object using child class
        animalInterface2.printAnimalName();//can call or access only the interface methods
    }
}
