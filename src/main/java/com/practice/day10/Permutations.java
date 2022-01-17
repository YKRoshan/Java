package com.practice.day10;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();

        permuteUtil(num, 0, num.length - 1, res);

        return res;
    }

    private static void permuteUtil(int[] num, int l, int r, List<List<Integer>> res) {
        if (l == r) {
            List<Integer> list = new ArrayList<>();
            for (int i : num)
                list.add(i);
            res.add(list);
        } else {
            for (int i = l; i <= r; i++) {
                swap(num, l, i);
                permuteUtil(num, l + 1, r, res);
                swap(num, l, i);
            }
        }
    }

    private static void swap(int[] num, int l, int i) {
        int t = num[l];
        num[l] = num[i];
        num[i] = t;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
