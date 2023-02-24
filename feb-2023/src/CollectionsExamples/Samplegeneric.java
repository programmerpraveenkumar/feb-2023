package CollectionsExamples;
/*
Arraylist<Integer>obj = new ArrayList<Integer>();
 */
public class Samplegeneric {
    public static void main(String[] args) {
        GenericClassSample<Integer> obj = new GenericClassSample<Integer>(45);
        obj.printVal();

        GenericClassSample<Double> objDbl = new GenericClassSample<Double>(45.25);
        objDbl.printVal();

        GenericClassSample<Boolean> objbln = new GenericClassSample<Boolean>(true);
        objbln.printVal();

    }
}

class GenericClassSample<T>{
    T val;
    public GenericClassSample(T v){
        this.val = v;
    }
    void printVal(){
        System.out.println(this.val);
    }
}
