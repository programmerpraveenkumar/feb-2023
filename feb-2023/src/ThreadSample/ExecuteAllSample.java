package ThreadSample;

import java.util.List;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteAllSample implements Callable<String> {
    String name = "";
    ExecuteAllSample(String name){
        this.name  = name;
    }
    public static void main(String[] args) {
        try{

            ExecutorService service = Executors.newCachedThreadPool();
            ArrayList<Callable<String>> callList = new ArrayList<Callable<String>>();
            callList.add(new ExecuteAllSample("test1"));
            callList.add(new ExecuteAllSample("test2"));
            callList.add(new ExecuteAllSample("test3"));
            callList.add(new ExecuteAllSample("test4"));
            callList.add(new ExecuteAllSample("test5"));
            List<Future<String>> res =  service.invokeAll(callList);//it returns anyone.
            res.forEach(obj->{
                try{
                    System.out.println(obj.get());
                }catch (Exception e){

                }
            });
            //System.out.println("anyone result ---"+res);
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

