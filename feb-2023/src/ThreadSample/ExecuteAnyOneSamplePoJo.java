package ThreadSample;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteAnyOneSamplePoJo implements Callable<Person> {
    String name = "";
    ExecuteAnyOneSamplePoJo(String name){
        this.name  = name;
    }
    public static void main(String[] args) {
        try{
            ExecutorService service = Executors.newCachedThreadPool();

            ArrayList<Callable<Person>> callList = new ArrayList<Callable<Person>>();
            callList.add(new ExecuteAnyOneSamplePoJo("test1"));
            callList.add(new ExecuteAnyOneSamplePoJo("test2"));
            callList.add(new ExecuteAnyOneSamplePoJo("test3"));
            callList.add(new ExecuteAnyOneSamplePoJo("test4"));
            callList.add(new ExecuteAnyOneSamplePoJo("test5"));
            Person res =  service.invokeAny(callList);//it returns anyone.
            System.out.println("anyone result ---"+res.getName()+"- "+res.getAge());
            //service.invokeAll(callList);
            service.shutdown();//should use ths for stop the executorService.
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Person call() throws Exception {
        Thread.sleep(1000);//1secs
        return  new Person(this.name,1);
    }
   }

