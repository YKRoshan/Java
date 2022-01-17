package com.practice.day6;

public class StartingPointOfLoopOfLinkedList {
    public static Node detectCycle(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;
        Node entry = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {                      // there is a cycle
                while (slow != entry) {               // found the entry location
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
