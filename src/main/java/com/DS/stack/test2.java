package com.DS.stack;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        System.out.println(weirdStock(3, 4));
    }

    private static int weirdStock(int n, int m) {
        System.out.println("n: " + n + " m: " + m);
        if (n == m || n <= 0 || m <= 0) return 0;
        if (n > m) return m - n;
        if(n>=m/2&&n<=m)
        return Math.min(1 + weirdStock(n - 1, m), 1 + weirdStock(n * 2, m));
        return  1 + weirdStock(n * 2, m);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

class test {
    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
            // node with no child
            if (current.left == null && current.right == null) {
                return null;
            }
            // node with only one child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            // node with two child
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    int height(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        int level = 1;
        if (root == null)
            return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.peek() != null) {

            Node p = q.remove();
            System.out.println(p.value);
            if (map.get(level) == null) {
                ans.add(p.value);
                map.put(level++, true);
            }
            if (p.left != null)
                q.add(p.left);
            if (p.right != null)
                q.add(p.right);
        }
        return ans;
    }
}