package com.day13;

class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node root = new Node(1);
        insert(root, 2);
        insert(root, 3);
        insert(root, 4);
        insert(root, 5);
        //root = reverseLL(root);
        root = reverseK(root,2);
        while (root != null) {
            System.out.println(root.data);
            root = root.next;
        }

    }

    private static Node reverseK(Node root, int k) {
        if (root == null) return null;

        Node prev = null;
        Node cur = root;
        Node next = cur.next;
        int c = 0;
        while (cur != null && c < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            c++;
        }

        if (next != null)
            root.next = reverseK(next, k);
        return prev;
    }

    private static Node reverseLL(Node root) {
        if (root == null) return null;

        Node prev = null;
        Node cur = root;
        Node next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static void insert(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Node temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
}
