package oops;

public class Forest {
    String name;
    /*
        constructor->
            it should same as classname
            no need to call explicitly,it will be called during the object creation
            it should be public.if not,cannot create object.
            all the method rules will be same for constructor also.recv params
            Usage:
                1.assign  the values for the variables
                2.loading the libraries during the object creation.
     */
    Forest(){
        System.out.println("this is constructor");
    }
    //constructor overloading
    Forest(String name){
            this.name = name;
        System.out.println("in the constructor.Name is "+this.name);
    }
    public static void main(String[] args) {
        new Forest();//object creation
        new Forest("sample name");
    }
}
