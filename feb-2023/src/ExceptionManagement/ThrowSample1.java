package ExceptionManagement;

public class ThrowSample1 {
    public static void main(String[] args) {
            ThrowSample1 throwObj = new ThrowSample1();
            throwObj.addition(5,15);
            try{
                System.out.println(throwObj.multiplication(45,20));
            }catch (Exception e){
                System.out.println("Error "+e);
            }
    }

    void addition(int a,int b){
        try{
            if(a<=10 || b<=10){
                //creating the error
                throw new CustomException("Number should be greater than 10");
            }
            System.out.println(a+b);
        }catch (CustomException e){
            System.err.println("Error "+e.getMessage());
        }
        //should throw the error if below or equals 10
    }

    /*
    throws->will declare method as it may return the error
     */
    int multiplication(int a, int b)throws  CustomException{
        if(a<=10 || b<=10){
            throw new CustomException("Number should be greater than 10");
        }
       return a*b;
    }
}
