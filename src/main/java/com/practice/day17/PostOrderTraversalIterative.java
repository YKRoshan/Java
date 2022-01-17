package com.practice.day17;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalIterative {
    static ArrayList<Integer> postOrderTraversal(Node root) {

        ArrayList<Integer> postOrder = new ArrayList<>();
        if (root == null) return postOrder;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.peek();
            s1.pop();
            s2.push(root);
            if (root.left != null)
                s1.push(root.left);
            if (root.right != null)
                s1.push(root.right);
        }

        while (!s2.isEmpty()) {
            postOrder.add(s2.peek().data);
            s2.pop();
        }
        return postOrder;
    }

}
