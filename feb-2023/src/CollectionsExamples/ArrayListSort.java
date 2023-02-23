package CollectionsExamples;

import java.util.*;
import java.util.stream.Collectors;

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
        List<Integer> afterFilter = listint.stream().filter(o->o>=3).collect(Collectors.toList());
        System.out.println(afterFilter);
//        try{
//
//        }catch (Exception e){
//
//        }
        //get the first elements

        Optional<Integer> firstElem = listint.stream().filter(o->o>=30).findFirst();
        if(firstElem.isPresent()){
            System.out.println(firstElem.get());//get the element from the optional
        }else{
            //can throw the erro
            System.out.println("no data found");
        }

        try{
            int firstElemasdf = listint.stream().filter(o->o>=3).findFirst().orElseThrow(()->new Exception("No Data Found"));
            System.out.println(firstElemasdf);
        }catch (Exception e){
            System.out.println("Exception "+e.getMessage());
        }


        //get the number greater than 3
//        for(Integer val:listint){
//            if(val>3){
//                System.out.println(val);
//            }
//        }

    }
}
