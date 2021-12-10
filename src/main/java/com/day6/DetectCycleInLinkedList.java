package com.day6;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class DetectCycleInLinkedList {
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
