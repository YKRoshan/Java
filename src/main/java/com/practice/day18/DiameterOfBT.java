package com.practice.day18;

public class DiameterOfBT {
    public int diameterOfBinaryTree(Node root) {
        if (root == null) return 0;
        return Math.max((height(root.left) + height(root.right)),
            Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left) + 1, height(root.right) + 1);
    }
}
