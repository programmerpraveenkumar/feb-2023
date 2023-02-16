package ThreadSample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadExecutor implements Callable<String> {


    public static void main(String[] args) {
        try{
            ExecutorService service = Executors.newCachedThreadPool();
            service.submit(new CachedThreadExecutor());
            service.submit(new CachedThreadExecutor());
            service.submit(new CachedThreadExecutor());
            service.submit(new CachedThreadExecutor());
            service.submit(new CachedThreadExecutor());
            service.submit(new CachedThreadExecutor());
            service.shutdown();//should use ths for stop the executorService.
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String call() throws Exception {
        System.out.println("Thread--callable");
        Thread.sleep(1000);//1secs
        return "sample output";
    }
}
