package dsa.stackandqueue;

import java.util.*;

class StackQueue {
    // declare a stack then use the methods of stack to mimic the queue methods.

    ArrayDeque<Integer> stack1 = new ArrayDeque<>();
    int top = -1;

    public StackQueue() {}

    public void push(int x) {
        // when stack is empty
        stack1.push(x);
        top++;
        int s = stack1.size();
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = stack1.pop();
            System.out.println("popping and storing arr i "+ arr[i]);
        }
        for(int i = 0; i < s ; i++){
            stack1.push(arr[i]);
            System.out.println("pushing arr i "+ arr[i]);
        }

        // when stack has few elements

    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

public class StackAndQueues {
    public static void main(String[] args) {

       /* Stack<Integer> stack = new Stack<>();

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
        System.out.println("size of queue :: " + queue.size());*/

        StackQueue stack = new StackQueue();

        stack.push(3);
        stack.push(5);

        System.out.println("stack is : "+stack.pop());

    }
}
