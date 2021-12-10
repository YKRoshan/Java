package com.day5;

public class RemoveNthFromEnd {
    public Node removeNthFromEnd(Node head, int n) {
        Node start = new Node();
        start.next = head;
        Node fast = start;
        Node slow = start;

        for (int i = 1; i <= n; ++i)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
