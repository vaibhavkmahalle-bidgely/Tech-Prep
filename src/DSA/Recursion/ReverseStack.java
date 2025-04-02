package DSA.Recursion;

import java.util.ArrayDeque;

public class ReverseStack {

    public static void mergeStack(ArrayDeque<Integer> stack, Integer f){
        if(stack.isEmpty()){
            stack.push(f);
            return;
        }
        Integer top = stack.pop();
        mergeStack(stack, f);
        stack.push(top);
    }

    public static void reverseStack(ArrayDeque<Integer> stack){
        //hypothesis :
        // reverseStack(1,2,3,4,5) -> muze given input reverse karke dega
        // reverseStack(2,3,4,5) -> muze smaller input ko reverse krke dega

        // induction :
        // 1 ko muze stack me dalna hai wo bhi sabse neeche

        if(stack.size() == 1)
            return;

        Integer f = stack.pop();

        reverseStack(stack);

        mergeStack(stack, f);

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

        reverseStack(stack);

        System.out.println("with middle element deleted stack: " + stack);
        System.out.println(stack.peek());
    }
}
