package ExceptionManagement;
/*
try-catch is the block for exception management
file handling,sql handling,http request(Spring boot),array handling,collections.
 */
public class Exception1Sample {
    public static void main(String[] args) {
        try{
            int res = 45/0;
            String[] nameAry = {"kjh","lljb"};
           System.out.println(nameAry[3]);
            System.out.println(nameAry[0]);
            System.out.println(nameAry[1]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error "+e);
        }catch (Exception e){
            System.out.println("Error "+e);
        }

        System.out.println("last --line ");
    }
}
