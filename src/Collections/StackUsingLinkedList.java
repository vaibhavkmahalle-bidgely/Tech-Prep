package collections;

import java.util.*;

public class StackUsingLinkedList {
    private LinkedList<Integer> stack = new LinkedList<>();

    // push operation on stack
    public void push(int a) {
        stack.addFirst(a);
        System.out.println("Added the element at top of stack");
    }

    // pop operation on stack
    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        return stack.removeFirst();
    }

    // Peek operation on stack
    public int peek() {
        if(stack.isEmpty()){
            throw new RuntimeException("Stack is Empty: ");
        }
        return stack.getFirst();
    }

    // size of Stack
    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        System.out.println("Checking isEmpty method : " + stack.isEmpty());
        System.out.println("Adding 5 elements : 4,5,2,3,8");
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(8);

        System.out.println("peeking in the stack : "+ stack.peek());

        System.out.println("Checking stack size : " + stack.size());

        System.out.println("Popping element of stack : "+ stack.pop());

        System.out.println("Current stack : " + stack);

    }
}
