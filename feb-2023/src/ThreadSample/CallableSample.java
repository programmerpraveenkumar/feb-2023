package ThreadSample;

import java.util.concurrent.*;

public class CallableSample implements Callable<String> {


    public static void main(String[] args) {
        try{
            ExecutorService service = Executors.newSingleThreadExecutor();//it runs only one thread.

            //future will pause the execution till it gets the result from the thread.
            Future<String> response = service.submit(new CallableSample());
            System.out.println("thread output "+response.get(3,TimeUnit.SECONDS));
           // service.submit(new CallableSample());//without handling the result.
            service.shutdown();//should use ths for stop the executorService.
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);//1secs
        return "sample output";
    }
}
