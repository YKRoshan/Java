package com.day6;

public class IsLinkedListPalindrome {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);
        slow = slow.next;
        while (slow != null) {
            if (head.data != slow.data)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;
        Node next = cur.next;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
