package DSA.Recursion;

import java.util.ArrayDeque;

public class SortStack {

    // Merges `top` into `stack` while maintaining sorted order
    public static void mergeStack(ArrayDeque<Integer> stack, Integer top){
        // Base condition: If stack is empty or `top` is greater than the top of stack
        if(stack.isEmpty() || top >= stack.peek()){
            stack.push(top);
            return;
        }

        // Remove top element and recurse
        Integer top1 = stack.pop();
        mergeStack(stack, top);

        // Push back the removed element
        stack.push(top1);
    }

    // Sorts the stack using recursion
    public static void sortStack(ArrayDeque<Integer> stack){
        // Base condition: If stack has only one element, it is sorted
        if(stack.size() <= 1){
            return;
        }

        // Remove the top element
        Integer top = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the popped element back in sorted order
        mergeStack(stack, top);
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

        sortStack(stack);

        System.out.println("Sorted stack: " + stack);
        System.out.println(stack.peek());
    }
}
