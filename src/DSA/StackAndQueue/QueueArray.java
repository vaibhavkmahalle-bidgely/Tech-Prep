package dsa.stackandqueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class ArrayQueue {
    private int[] queueArray;
    private int startIndex;
    private int endIndex;
    private int currSize, maxSize;

    public ArrayQueue() {
        queueArray = new int[10];
        startIndex = -1;
        endIndex = -1;
        currSize = 0;
        maxSize = 10;
    }

    public void push(int x) {
        if (currSize >= maxSize - 1) {
            System.out.println("Queue is overflown:");
            return;
        }
        if (isEmpty()) {
            startIndex = 0;
        }
        queueArray[++endIndex] = x;
        currSize++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            int popped = queueArray[startIndex];
            startIndex++;
            currSize--;
            return popped;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return queueArray[startIndex];
        }
    }

    public boolean isEmpty() {
        return startIndex == -1;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
    }
}
