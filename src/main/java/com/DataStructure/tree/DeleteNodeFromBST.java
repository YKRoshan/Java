package com.DataStructure.tree;

public class DeleteNodeFromBST {
    static Node findMin(Node root) {
        return root.left == null ? root : findMin(root.left);
    }

    public static Node deleteNode(Node root, int v) {
        if (root == null || root.left == null && root.right == null)
            return null;
        if (root.data == v) {
            if (root.left != null && root.right != null) {
                int m = findMin(root.left).data;
                root.data = m;
                root.left = deleteNode(root.left, m);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else return root.right;
        } else if (v < root.data) {
            root.left = deleteNode(root.left, v);
            return root;
        } else {
            root.right = deleteNode(root.right, v);
            return root;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Tree1_BSTOperations tree = new Tree1_BSTOperations();
        System.out.println(tree.insertion(root, 4).data);
        System.out.println(tree.insertion(root, 7).data);
        System.out.println(tree.insertion(root, 1).data);
        System.out.println(tree.insertion(root, 15).data);

        System.out.println(deleteNode(root, 7));
    }
}
