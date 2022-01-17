package com.practice.day17;

import java.util.ArrayList;

public class LeftViewRecursive {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        leftViewUtil(root, 0, list);
        return list;
    }

    private void leftViewUtil(Node root, int level, ArrayList<Integer> list) {
        if (root == null) return;

        if (list.size() == level)
            list.add(root.data);

        leftViewUtil(root.right, level + 1, list);
        leftViewUtil(root.left, level + 1, list);
    }
}
