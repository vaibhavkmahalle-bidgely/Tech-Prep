package dsa.stackandqueue;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayDeque;
import java.util.EmptyStackException;

public class MinStack {
   static ArrayDeque<Integer>  sStack = new ArrayDeque<>();
   static ArrayDeque<Integer> stack = new ArrayDeque<>();

    public static void push(int val) {
        stack.push(val);

        if(sStack.isEmpty()){
            sStack.push(val);
        }else {
            if(val <= sStack.peek()){
                sStack.push(val);
            }
        }
    }

    public static void pop() {
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        if(stack.peek() == sStack.peek()){
            stack.pop();
            sStack.pop();
        }else{
            stack.pop();
        }

    }

    public static int top() {
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    public static int getMin() {
        if(sStack.isEmpty()){
            throw new EmptyStackException();
        }
            return sStack.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[]{-2,0,-3};
        MinStack s = new MinStack();

        for(int e : input){
            s.push(e);
        }

        System.out.println("Get min :" + getMin());
        System.out.println("top :" + top());
        pop();
        System.out.println("Get min :" + getMin());
        System.out.println("top :" + top());
        pop();
        System.out.println("Get min :" + getMin());
        System.out.println("top :" + top());
        pop();
        System.out.println("Get min :" + getMin());
        System.out.println("top :" + top());


    }
}
