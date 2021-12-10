package com.day5;

public class MergeTwoLinkedLists {
    Node mergeTwoLists(Node l1, Node l2) {
        // iterative 
        Node res = new Node();
        Node temp = res;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            res.next = l1;
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            res.next = l2;
            res = res.next;
            l2 = l2.next;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
