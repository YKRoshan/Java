package example;

class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class Test1 {
    public static boolean isLoop(Node root) {
        if (root == null) return true;

        Node slow = root;
        Node fast = root.next;
        while (fast != null || fast.next == null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
    }
}
