package DSA.StackAndQueue;

import java.util.ArrayDeque;

class QueueUsingStack {
    ArrayDeque<Integer> stack1 = new ArrayDeque<>();
    ArrayDeque<Integer> stack2 = new ArrayDeque<>();
    int top1 = -1, top2 = -1;

    public QueueUsingStack() {
    }

    public void push(int x) {
        if (isEmpty()) {
            System.out.println("printing empty stack " + stack1);
            stack1.push(x);
            top1++;
            System.out.println("just after pushing first element " + stack1 + "top1 : " + top1);
        } else {
            if (top1 != -1 && top2 == -1) {
                stack2.push(x);
                top2++;
                while (top1 != -1) {
                    stack2.push(stack1.pop());
                    top2++;
                    top1--;
                }
                System.out.println("printing stack1 ,top1 : " + stack1 + "," + top1 + " stack 2 , top2 : " + stack2 + ", " + top2);
            }
            if (top1 == -1 && top2 != -1) {
                stack1.push(x);
                top1++;
                while (top2 != -1) {
                    stack1.push(stack2.pop());
                    top1++;
                    top2--;
                }
            }
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            if (top1 != -1 && top2 == -1) {
                top1--;
                return stack1.pop();
            }

            if (top1 == -1 && top2 != -1) {
                top2--;
                return stack2.pop();
            }
            return stack1.peek();
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            if (top1 != -1 && top2 == -1) {
                return stack1.peek();
            }

            if (top1 == -1 && top2 != -1) {
                return stack2.peek();
            }
            return stack1.peek();
        }
    }

    public boolean isEmpty() {
        return (top1 == -1 && top2 == -1);
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        System.out.println("checking if queue is empty : " + queue.isEmpty());
        queue.push(2);
        queue.push(5);
        System.out.println("checking if queue is empty : " + queue.isEmpty());
        System.out.println("peeking the top : " + queue.peek());

    }
}
