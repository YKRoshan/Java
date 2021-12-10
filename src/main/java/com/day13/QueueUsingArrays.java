package com.day13;

class MyQueue {
    public static final int SIZE = 100;
    int[] queue = new int[SIZE];
    int front = 0;
    int rear = 0;

    public boolean enQueue(int data) {
        if (rear < front)
            return false;
        queue[rear++] = data;
        return true;
    }

    public boolean deQueue() {
        if (front == queue.length)
            return false;
        front++;
        return true;
    }

    public void display() {
        for (int i = front; i < rear; i++) {
            System.out.println(queue[i]);
        }
    }
}

public class QueueUsingArrays {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.deQueue();
        queue.enQueue(4);
        queue.enQueue(5);
        queue.display();
    }
}
