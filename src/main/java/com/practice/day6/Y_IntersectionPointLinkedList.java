package com.practice.day6;

/*
1 2 3 4 5
          9 10 11
    6 7 8

Solution 1(Brute Force):
1.Use two for loop
2.Find a first common Node

Time Complexity: O(N^N)
Space Complexity: O(1)

Solution 2(Optimal1):
1.Calculate length of both LL (say it is l1 and l2)
2.Traverse bigger LL(say l2) to l2-l1 distance
3.Since both LL are same length now so start iterating both LL simultaneously
4.Return first common node
Time Complexity: O(L1)+O(L2)
Space Complexity: O(1)

Solution 3(Optimal2):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

*/
public class Y_IntersectionPointLinkedList {
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node a = headA;
        Node b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linked-list
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
