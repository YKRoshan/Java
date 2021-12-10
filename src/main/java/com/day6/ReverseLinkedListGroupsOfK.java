package com.day6;

public class ReverseLinkedListGroupsOfK {

    public static Node reverseList(Node head, int k) {
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;
        Node next = cur.next;
        int i = 1;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
            i++;
            if (i == k)
                break;
        }
        cur.next = prev;
        head.next = reverseList(next, 3);
        return cur;
    }

    public static Node push(Node head, int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        return new_node;
    }


    public static void main(String[] args) {
        Node node = new Node(6);
        node = push(node, 5);
        node = push(node, 4);
        node = push(node, 3);
        node = push(node, 2);
        node = push(node, 1);
        Node temp = node;
        temp = reverseList(node, 3);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
