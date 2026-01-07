package dsa.recursion;

import java.util.ArrayDeque;

public class DeleteMiddleElementOfStack {

    public static void deleteMiddle(ArrayDeque<Integer> stack, int k){
        // base condition
        if(k == 1){
            stack.pop();
            return;
        }

        Integer num = stack.pop();

        deleteMiddle(stack,k-1);

        stack.push(num);


    }

    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Input stack: 1, 9, 6, 8, 5, 4, 0
        stack.push(1);
        stack.push(9);
        stack.push(6);
        stack.push(8);
        stack.push(5);
        stack.push(4);
        stack.push(0);

        System.out.println("Original stack: " + stack);

        deleteMiddle(stack, stack.size()/2+1);

        System.out.println("with middle element deleted stack: " + stack);
        System.out.println(stack.peek());
    }

}
