public class AnotherClass {
    String firstName = "from Another Class";
    int number = 45;
    protected int age = 85;
    public int getNumber(){
        return 565;
    }
    public void printName(){
        System.out.println("sample output");
    }
    private void getMessage(){
        System.out.println("sample message");
    }
    protected void getMessgae2(){
        System.out.println("sample method..");
    }
    void printMessage3(){
        getMessage();;//can access private method
        System.out.println("sample message");
    }

}
