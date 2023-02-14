public class ForClassSample {
    public static void main(String[] args) {
        for(int i = 1;i<10;i++){
            System.out.println(i);
        }
        boolean status = true;
        int start = 1;
        while(start<10){
            System.out.println("running while loop");
            status = false;
            start++;
        }
        do{
            System.out.println("inside do while");
        }while(false);
    }
}
