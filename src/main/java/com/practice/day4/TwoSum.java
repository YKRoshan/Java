package com.practice.day4;

import java.util.HashSet;

public class TwoSum {
    public static int[] twoSum(int[] arr, int target) {
        int ans[] = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int n : arr) {
            if (set.contains(target - n)) {
                ans[0] = target - n;
                ans[1] = n;
                return ans;
            } else {
                set.add(n);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] ans = twoSum(numbers, 9);
        for (int n : ans)
            System.out.print(n + " ");
    }
}
