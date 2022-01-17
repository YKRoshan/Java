package com.practice.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import static java.lang.System.*;

class Node {
    int data;
    Node right;
    Node left;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Test {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        topView(root);
        verticalTraversal(root);
        bottomView(root);
    }

    private static void bottomView(Node root) {
        {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            Queue<HashMap<Node, Integer>> queue = new LinkedList<>();
            HashMap<Node, Integer> map = new HashMap<>();
            map.put(root, 0);
            queue.add(map);
            while (!queue.isEmpty()) {
                HashMap<Node, Integer> map1 = queue.poll();
                Node node = map1.keySet().iterator().next();
                int dist = map1.get(node);

                treeMap.put(dist, node.data);

                if (node.left != null) {
                    HashMap<Node, Integer> map2 = new HashMap<>();
                    map2.put(node.left, dist - 1);
                    queue.add(map2);
                }

                if (node.right != null) {
                    HashMap<Node, Integer> map2 = new HashMap<>();
                    map2.put(node.right, dist + 1);
                    queue.add(map2);
                }
            }

            treeMap.forEach((k, v) -> out.print(v+" "));
        }
    }

    private static void verticalTraversal(Node root) {
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        Queue<HashMap<Node, Integer>> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        map.put(root, 0);
        queue.add(map);
        while (!queue.isEmpty()) {
            HashMap<Node, Integer> map1 = queue.poll();
            Node node = map1.keySet().iterator().next();
            int dist = map1.get(node);
            if (treeMap.containsKey(dist)) {
                ArrayList<Integer> list = treeMap.get(dist);
                list.add(node.data);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.data);
                treeMap.put(dist, list);
            }
            if (node.left != null) {
                HashMap<Node, Integer> map2 = new HashMap<>();
                map2.put(node.left, dist - 1);
                queue.add(map2);
            }
            if (node.right != null) {
                HashMap<Node, Integer> map2 = new HashMap<>();
                map2.put(node.right, dist + 1);
                queue.add(map2);
            }

        }
        treeMap.forEach((k, v) -> out.println(v));
    }

    private static void topView(Node root) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<HashMap<Node, Integer>> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap();
        map.put(root, 0);
        queue.add(map);

        while (!queue.isEmpty()) {
            HashMap<Node, Integer> m = queue.poll();
            Node node = m.keySet().iterator().next();
            int dist = m.get(node);
            if (!treeMap.containsKey(dist)) {
                treeMap.put(dist, node.data);
            }
            if (node.left != null) {
                HashMap<Node, Integer> map1 = new HashMap();
                map1.put(node.left, dist - 1);
                queue.add(map1);
            }
            if (node.right != null) {
                HashMap<Node, Integer> map1 = new HashMap();
                map1.put(node.right, dist + 1);
                queue.add(map1);
            }
        }

        treeMap.forEach((k, v) -> out.println(v));

    }
}




/*{
    void inorder() {
        if (root == null)
            return;


        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {

            *//* Reach the left most Node of the
            curr Node *//*
            while (curr != null) {
                *//* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree *//*
                s.push(curr);
                curr = curr.left;
            }

            *//* Current must be NULL at this point *//*
            curr = s.pop();

            System.out.print(curr.data + " ");

            *//* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn *//*
            curr = curr.right;
        }
    }

    static ArrayList list = new ArrayList();

    public static void main(String[] args) {
        String str = "ABCD";
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            String s1 = String.valueOf(chars[i]);
            printPermutation(s1, 0, s1.length());
            for (int j = i + 1; j < n; j++) {
                s1 = String.valueOf(chars[j]).concat(s1);
                printPermutation(s1, 0, s1.length());
            }
        }

        Collections.sort(list);
        list.forEach(l -> System.out.println(l));
    }

    private static void printPermutation(String str, int l, int r) {
        if (r == l) {
            list.add(str);
        } else {
            for (int i = l; i < r; i++) {
                str = swap(str, l, i);
                printPermutation(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = str.charAt(i);
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }
}*/
/*
public class Example {
    public static void main(String[] args) {
        System.out.println(substringCalculator("kincenvizh"));
    }

    public static int substringCalculator(String s) {
        if (s.isEmpty())
            return 0;

        Set<String> set = new HashSet<>();
        int count = 0;
        int p = 0;

        for (int l = s.length(); l >= 1; l--) {

            for (int i = 0; i < s.length() - l + 1; i++) {

                int j = i + l;
                String sub = s.substring(i, j);

                if (!set.contains(sub)) {
                    count++;
                    set.add(sub);
                } else {
                    p++;
                }

            }
        }
        return count;
    }
}
*/
/*
public class Example {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 10, 15} ;
        System.out.println(countPair(arr, arr.length));
    }

    private static int countPair(int[] arr, int n) {
        int count = 0;
        if (arr.length < 2) return 0;
        Arrays.sort(arr);
        int minDiff = arr[0] - arr[1];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] - arr[j] == minDiff)
                    count++;
                if (arr[i] - arr[j] > minDiff)
                    break;
            }
        }

        return count;
    }
}
*/
