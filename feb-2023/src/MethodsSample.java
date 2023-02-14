import java.lang.reflect.Method;

public class MethodsSample {
    public static void main(String[] args) {
        MethodsSample method = new MethodsSample();
        method.addition();//cal the method using object.
        System.out.println(method.mul());
        method.add(10,15);
        method.add(40,15);
        method.add(40,15,"Addition Text ");
        method.add(50,15,"Addition Text ");
        method.add(50,15,45);
        AnotherClass another = new AnotherClass();
        System.out.println(another.getNumber());
        another.printName();//caling using object.
        //another.getMessage();//cannot access as it is in the private
        //System.out.println(another.printName());//error as it expects the value to print
        another.getMessgae2();//can access the protected methods.
        another.printMessage3();//can access the default method.
        StaticMethodSample.printMessage();//calling static method using objects.
    }
    public void addition(){
        int res = 5+5;
        System.out.println(res);
    }
    public int mul(){
        int res = 5+5;
        return res;//should be last line of the method.
       // System.out.println("asdfas;df");//error..no statements after the return.
    }
    public void add(int a, int b){
        int res = a+b;
        System.out.println(res);
    }
    //method overloading.same name but different args.
    public void add(int a, int b,String message){
        int res = a+b;
        System.out.println(message+res);
    }
    public void add(int a, int b,long longVar){
        long res = a+b+longVar;
        System.out.println("3rd method "+res);
    }
    public void greaterThanOprtr(){
        System.out.println(100>45);//true
        System.out.println(100<45);//false

    }
    /*methods->can create logics to the method.
    //can reuse the methods.
    syntax:
    access_specifier return_type||void name_function(){

    }
    access_specifier->public,private,protected,default(no need to mention)
    return_type->what value the method is going to return.
                number->int
     void-> no return type.
     */

}
