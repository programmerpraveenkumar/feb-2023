package ThreadSample;

public class ThreadRunnableSample implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());//get name of the current thread
        System.out.println("sample thread runnable- from the run method");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ThreadRunnableSample threadRunnableSample = new ThreadRunnableSample();
        Thread thread = new Thread(threadRunnableSample);
        thread.start();//will call the above run method
        //thread.run();
    }
}
