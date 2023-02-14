package oops;

public class Product1 extends AbsClass {
    public static void main(String[] args) {
        Product1 product1 = new Product1();
        product1.productName = "pr1";
        product1.price = 45;
        product1.printName();
        product1.printPrice();
    }

    @Override
    void printPrice() {
        System.out.println("Price is "+this.price);
    }
}
