package oops;

public class Lion implements AnimalInterface,AnimalInterface2 {
    @Override
   public void printForestName(){
        System.out.println("it is in the Amazon forest and age is "+this.getAge());
    }

    //should not have any definition.
    @Override
    public int getAge(){
        return 10;
    }

    public static void main(String[] args) {
        Lion lion = new Lion();
        lion.printAnimalName();
        lion.printForestName();


    }
    public void printExactLocation(){
        System.out.println("Location is amz-122");
    }

    @Override
    public void printAnimalName() {
        System.out.println("Animal name is Lion");
    }
}
