package com.practice.day6;

class ListNode {
    int data;
    ListNode next;
    ListNode bottom;

    public ListNode(int data) {
        this.data = data;
    }
}

public class FlatteningOfLinkedList {
    ListNode mergeTwoLists(ListNode a, ListNode b) {

        ListNode temp = new ListNode(0);
        ListNode res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a != null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;

    }

    ListNode flatten(ListNode root) {

        if (root == null || root.next == null)
            return root;

        // recur for list on right
        root.next = flatten(root.next);

        // now merge
        root = mergeTwoLists(root, root.next);

        // return the root
        // it will be in turn merged with its left
        return root;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
