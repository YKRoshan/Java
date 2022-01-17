package com.practice.day5;

public class ReverseLinkedList {
    public Node reverseList(Node head) {
        Node temp = null;
        while (head != null) {
            Node next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }

    public static void main(String[] args) {

        System.out.println();
    }
}
