package test;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

// 1-> 2-> 3-> 4
/*
Fun2 1 2 3 4
count 1 2

2

*/
// -> 5 -> 6 -> 7
// t1=1,2,3,4,5
// t2=2,4,6,null
//1
//1->2

public class Mcafee_2 {
    static int count = 0;

    static void fun2(Node root, int n) {
        if (root == null) return;
        fun2(root.next, n);
        count++;
        if (count == n)
            System.out.println(root.data);
    }

    static void fun(Node root) {
        Node temp = root;
        if (temp == null)
            return;
        if (temp.next == null) {
            System.out.println(temp.data);
            return;
        }
        if (temp.next.next == null) {
            System.out.println(temp.data);
            System.out.println(temp.next.data);
            return;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.data);
        System.out.println(temp.next.data);
    }
    //public static

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        //fun(root);
        fun2(root, 2);
    }
}
