package CollectionsExamples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListSort {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("lion");
        list.add("cat");
        list.add("zebra");
        list.add("tiger");
        System.out.println(list);
        Collections.sort(list);//sort the data.
        System.out.println(list);

        ArrayList<Integer> listint = new ArrayList<>();
        listint.add(5);
        listint.add(1);
        listint.add(3);
        listint.add(2);
        listint.add(4);
        System.out.println(listint);
        Collections.sort(listint);//sort the data.
        System.out.println(listint);

    }
}
