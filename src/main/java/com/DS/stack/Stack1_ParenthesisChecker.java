package com.DS.stack;

import java.util.*;
import java.lang.*;

class Stack1_ParenthesisChecker {
    //Function to check if brackets are balanced or not.
    static boolean isBalanced(String x) {
        // add your code here
        Stack<Character> stack1 = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            stack1.push(x.charAt(i));
        }

        Stack<Character> stack2 = new Stack<>();
        while (!stack1.empty()) {
            char top = stack1.pop();
            if (!stack2.empty() && (top == '[' && stack2.peek() == ']' || top == '{'
                && stack2.peek() == '}' || top == '(' && stack2.peek() == ')')) {
                stack2.pop();
            } else
                stack2.push(top);
        }
        return stack2.empty() ? true : false;
    }

    static int minParentheses(String p) {

        // maintain balance of string
        int bal = 0;
        int ans = 0;

        for (int i = 0; i < p.length(); ++i) {

            bal += p.charAt(i) == '(' ? 1 : -1;

            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans += 1;
                bal += 1;
            }
        }

        return bal + ans;
    }

    public static void main(String[] args) {
        //  System.out.println(isBalanced("{}[(())]"));
        System.out.println(minParentheses("(()"));
    }
}
