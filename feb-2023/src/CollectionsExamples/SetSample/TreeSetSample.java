package CollectionsExamples.SetSample;

import java.rmi.server.ObjID;
import java.util.TreeSet;

/*
will not allow for the duplicates
it will not maintain the insertion order
it will maintain the ascending order.
 */
public class TreeSetSample {
    public static void main(String[] args) {
        TreeSet<String> obj = new TreeSet<>();
        obj.add("zebra");
        obj.add("lion");
        obj.add("cat");
        obj.add("tiger");
        obj.add("lion");//will not be added.set does not accept the duplicates.
        System.out.println(obj);

        TreeSet<Integer> objInt = new TreeSet<Integer>();
        objInt.add(12);
        objInt.add(13);
        objInt.add(45);
    }
}
