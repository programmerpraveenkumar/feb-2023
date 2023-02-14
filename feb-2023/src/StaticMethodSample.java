public class StaticMethodSample {
    public static void main(String[] args) {
            //StaticMethodSample sample = new StaticMethodSample();
            printMessage();//static method does not need objects.
           // printMessage2();//not a static method will throw the error.
    }
    public static void printMessage(){
        System.out.println("Sample Message");
        //printMessage3();error,cannot call non-static from the static method.if it has to call,need to create object.
    }
    public void printMessage2(){
        System.out.println("sample message2");
    }
    public void printMessage3(){
        printMessage3();//can call the static method.
        System.out.println("sample message3");
    }
}
