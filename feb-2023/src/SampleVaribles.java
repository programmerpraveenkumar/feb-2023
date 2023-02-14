public class SampleVaribles {
    int mobileNo = 445454;//global variables
    String firstName = "sample name";
    public static void main(String[] args) {
        //main method cannot access the variables
        //through the object can access the variables
        //Classname obj = new Classname()
        SampleVaribles sampleVaribles =  new SampleVaribles();
        System.out.println(sampleVaribles.mobileNo);//access the variable using object.
        System.out.println(sampleVaribles.firstName);//access the variable using object.
        AnotherClass another = new AnotherClass();
        another.firstName = "sample firstName";
        another.number = 454;
        another.age = 45;//private variable cannot have access
        System.out.println(another.firstName);
        System.out.println(another.number);
    }
}
