package CollectionsExamples;

public class GenericMethodMain {
    public static void main(String[] args) {
        testGeneric(10);
        testGeneric(true);
        testGeneric(145.5);
        testGeneric("adsfadsf");
    }
    public  static  <T>  T testGeneric(T val){
        System.out.println(val);
        return val;
    }
    public  static  <T,K>  void testGeneric(T val,K val2){
        System.out.println(val);
    }
}
