package com.practice.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalIterative {
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (true) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                if (stack.empty()) break;
                Node node = stack.pop();
                temp = node.right;
                res.add(node.data);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
    }
}
