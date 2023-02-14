public class ConditionsSample {
    public static void main(String[] args) {
        int num = 45;
        int num2 = 9;
        if(num2>num){
            System.out.println("num2 is greater");
        }else{
            System.out.println("num is greater");
        }


        //chain if
        int num3 = 66;
        if(num3>50){
            System.out.println("Number is greater than 50");
        }else if(num3>20){
            System.out.println("Number is greater than 20");
        }else if(num3>10){
            System.out.println("Number is greater than 10");
        }else{
            System.out.println("Number is lesser than 50");
        }
    }
}
