package com.practice.day17;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree {
    public int widthOfBinaryTree(Node root) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        if (root == null) return 0;
        widthUtil(root, list, 0, 0);
        return list.get(0) + list.get(1);
    }

    private void widthUtil(Node root, List<Integer> list, int ld, int rd) {
        if (root.left != null) {
            Integer value = list.remove(0);
            list.add(0, Math.max(value, ld + 1));
            widthUtil(root.left, list, ld + 1, rd);
        }
        if (root.right != null) {
            Integer value = list.remove(1);
            list.add(1, Math.max(value, rd + 1));
            widthUtil(root.right, list, ld, rd + 1);
        }
    }
}
