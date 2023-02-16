package ThreadSample;
/*
diff b/w start and run
start->will create thread and execute the logic in the new thread
run()->will execute the logic on the main thread.it will not create new thread.
 */
public class ThreadFirst extends Thread {
    //override the parent class method
    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());//get name of the current thread
        System.out.println("sample thread from the run method");
    }

    public static void main(String[] args) {
        ThreadFirst first = new ThreadFirst();
        System.out.println(Thread.currentThread().getName());//get name of the current thread
        first.start();//create the new thread and execute the thread.
       // first.run();
    }
}
