package CollectionsExamples;

import java.util.ArrayDeque;
import java.util.Queue;
/*
FIFO->first in first out
 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queueObj = new ArrayDeque<>();
        queueObj.add("test");
        queueObj.add("test1");
        queueObj.add("test2");
        System.out.println(queueObj);
        System.out.println(queueObj.peek());//return the first item in the queue
        System.out.println(queueObj.poll());//return and remove the first item in the queue
        System.out.println(queueObj);
        System.out.println(queueObj.peek());//return the first item in the queue
        queueObj.remove("test2");


    }
}
