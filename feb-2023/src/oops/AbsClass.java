package oops;
/*
    cannot create object for abstract class
    So it can be used only in the inheritance
    if any methods declared as abstract,it should be override in the child class.
 */
public abstract class AbsClass {
    int price;
    String productName;
    void printName(){
        System.out.println("Name is "+this.productName);
    }
   abstract void printPrice();//should not have any definition.
}
