package com.day5;

public class DeleteGivenNode {
    public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
