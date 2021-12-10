package com.day13;

class MyStack {
    public static final int SIZE = 100;
    private int[] stack = new int[SIZE];
    private int top = 0;

    public boolean push(int data) {
        if (top == 100) {
            System.out.println("Stack is full.");
            return false;
        }
        stack[top++] = data;
        return true;
    }

    public int pop() {
        if (top == 0) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int data = stack[top--];
        return data;
    }

    public void display() {
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }
    }

    public int getSize() {
        return top;
    }
}

public class StackUsingArrays {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.push(5);
        stack.display();
    }
}
