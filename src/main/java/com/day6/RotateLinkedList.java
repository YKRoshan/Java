package com.day6;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int l = 0;
        ListNode temp = head;
        while (temp.next != null) {
            l++;
            temp = temp.next;
        }
        l++;
        temp.next = head;

        k = k % l;
        temp = head;
        for (int i = 0; i < l - k - 1; i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        // edge cases
        if (head == null || head.next == null || k == 0) return head;

        // compute the length
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }

        // go till that node
        cur.next = head;
        k = k % len;
        k = len - k;
        while (k-- > 0) cur = cur.next;

        // make the node head and break connection
        head = cur.next;
        cur.next = null;

        return head;
    }
}
