package ThreadSample;

import java.util.concurrent.*;

public class FiexdThreadExecutor implements Callable<String> {


    public static void main(String[] args) {
        try{
            int totalProcessor = Runtime.getRuntime().availableProcessors();
            System.out.println("Total processor "+totalProcessor);
            //executes 4 threads
            ExecutorService service = Executors.newFixedThreadPool((totalProcessor-2));

            service.submit(new FiexdThreadExecutor());
            service.submit(new FiexdThreadExecutor());
            service.submit(new FiexdThreadExecutor());
            service.submit(new FiexdThreadExecutor());
            service.submit(new FiexdThreadExecutor());
            service.submit(new FiexdThreadExecutor());
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
