/*
First letter should be caps
file name shld be same classname
ends with .java extension.
it shuld have main method to execute.

JDK->Java Development kit
JRE->Java RunTime Environment
 */
public class First {
    /*
        public-> can be access from JDK
        static-> can access using the classname
        void-> no return type.
        main->common name between class and JDK
        string args[]-> run time args with multiple values.
        First.main()
     */
    public static void main(String args[]){
        /*
            primitive data type
                does not have object props
                1.cannot create object
                2.cannot be used in oops .
                boolean,int,long,float,double,char,short,byte
         */
        boolean status = true;//declare the variables
        int age  = 454;//number//int and long
        double price = 45.50;//float and double
        char letter = 'j';

        String firstName = "adsfasdfasdfadsfadsfadsf";//class
        System.out.println(status);
        System.out.println(age);
        System.out.println(price);
        System.out.println(letter);
        System.out.println("Hello world");//only for development
    }
}
