package ThreadSample;


import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteAnyOneSample implements Callable<String> {
    String name = "";
    ExecuteAnyOneSample(String name){
        this.name  = name;
    }
    public static void main(String[] args) {
        try{
            ExecutorService service = Executors.newCachedThreadPool();

            ArrayList<Callable<String>> callList = new ArrayList<Callable<String>>();
            callList.add(new ExecuteAnyOneSample("test1"));
            callList.add(new ExecuteAnyOneSample("test2"));
            callList.add(new ExecuteAnyOneSample("test3"));
            callList.add(new ExecuteAnyOneSample("test4"));
            callList.add(new ExecuteAnyOneSample("test5"));
            String res =  service.invokeAny(callList);//it returns anyone.
            System.out.println("anyone result ---"+res);
            //service.invokeAll(callList);

            service.shutdown();//should use ths for stop the executorService.
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);//1secs
      //  System.out.println("Thread--callable "+this.name);
        return this.name;
    }
   }

