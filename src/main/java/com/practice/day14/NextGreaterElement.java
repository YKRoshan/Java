package com.practice.day14;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 3};
        int[] elements = nextGreaterElement(arr, arr.length);
        for (int i : elements)
            System.out.print(i + " ");
    }

    private static int[] nextGreaterElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        //double the size for circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            //if i>n then % will return the value
            int val = arr[i % n];
            while (!stack.empty() && val >= stack.peek()) {
                stack.pop();
            }
            //if i<n then only add value to ans
            if (i < n) {
                if (!stack.empty() && stack.peek() > arr[i])
                    ans[i] = stack.peek();
                else
                    ans[i] = -1;
            }
            stack.push(val);
        }
        return ans;
    }
}
