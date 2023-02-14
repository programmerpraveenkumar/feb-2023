package ExceptionManagement;

public class ThrowSample {
    public static void main(String[] args) {
            ThrowSample throwObj = new ThrowSample();
            throwObj.addition(45,15);
            try{
                System.out.println(throwObj.multiplication(45,20));
            }catch (Exception e){
                System.out.println("Error "+e);
            }
        //
    }

    void addition(int a,int b){
        try{
            if(a<=10 || b<=10){
                //creating the error
                throw new Exception("Number should be greater than 10");
            }
            System.out.println(a+b);
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
        }
        //should throw the error if below or equals 10
    }

    /*
    throws->will declare method as it may return the error
     */
    int multiplication(int a, int b)throws  Exception{
        if(a<=10 || b<=10){
            throw new Exception("Number should be greater than 10");
        }
       return a*b;
    }
}
