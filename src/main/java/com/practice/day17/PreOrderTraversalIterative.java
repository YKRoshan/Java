package com.practice.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIterative {
    public List<Integer> preOrderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (true) {
            if (temp != null) {
                res.add(temp.data);
                stack.push(temp);
                temp = temp.left;
            } else {
                if (stack.empty()) break;
                Node node = stack.pop();
                temp = node.right;
            }
        }
        return res;
    }
}
