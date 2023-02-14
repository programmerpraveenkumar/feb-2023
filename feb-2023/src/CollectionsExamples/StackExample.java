package CollectionsExamples;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*
FIFO->first in first out
 */
public class StackExample {
    public static void main(String[] args) {
        Stack<String> stackObj = new Stack<>();
        stackObj.add("test");
        stackObj.add("test1");
        stackObj.add("test2");
        System.out.println(stackObj);
        System.out.println(stackObj.peek());//return the last item in the stack
        System.out.println(stackObj.pop());//return and remove the last item in the stack
        System.out.println(stackObj);
        System.out.println(stackObj.peek());//return the last item in the stack
        stackObj.remove("test2");


    }
}
