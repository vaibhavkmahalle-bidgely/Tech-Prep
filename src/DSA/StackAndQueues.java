package DSA;

import java.io.PrintStream;
import java.util.*;

public class StackAndQueues {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(6);
        stack.push(4);
        stack.push(2);
        stack.push(8);


        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println("Object is at this location from top :::::: " + stack.search(5));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        stack1.push(2);
        stack1.push(22);
        stack1.push(222);
        stack1.push(2222);
        stack1.push(22222);

        System.out.println("printing the whole stack : " + stack1);

        System.out.println("top of stack : " + stack1.peek());

        System.out.println("search 2 in stack : " + stack1);

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(2);
        queue.add(3);
        System.out.println("peeking in queue :: " + queue.peek());
        queue.add(2);
        queue.add(3);
        System.out.println("size of queue :: " + queue.size());
        System.out.println("Dequeue operation :: " + queue.remove());
        System.out.println("peeking in queue :: " + queue.peek());
        System.out.println("size of queue :: " + queue.size());

    }
}
