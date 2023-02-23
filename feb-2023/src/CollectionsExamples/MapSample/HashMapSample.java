package CollectionsExamples.MapSample;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
hashmap ill store the value in key and value
key should be unique.unless value will be overridden.
it will not maintain insertion order
 */
public class HashMapSample {
    public static void main(String[] args) {
        HashMap<Integer,String> obj = new HashMap<Integer,String>();
        obj.put(1,"test");//add the value
        obj.put(2,"test1");
        obj.put(3,"test2");
        System.out.println(obj.get(1));//access the value using key
        System.out.println(obj.remove(2));
        System.out.println(obj);
        obj.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
        obj.put(5,"asdfds");
        obj.put(3,"test3");//previous value will be override
        System.out.println(obj);

        HashMap<Long,String> objMap = new HashMap<Long,String>();
        objMap.put(6l,"adsf");
        objMap.put(454l,"testsdf");

        Map<Long,String> afterFilter = objMap.entrySet().stream().filter(mObj->mObj.getKey()==6l).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println("after filter ");
        System.out.println(afterFilter);
        afterFilter.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
    }
}
