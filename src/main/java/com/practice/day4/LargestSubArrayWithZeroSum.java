package com.practice.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LargestSubArrayWithZeroSum {
    public static int maxLen(int arr[], int n) {

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            /*
             * Important-
             * if sum at any point is zero then in that case maximum length will be
             * index + 1 (Think)
             * */
            if (sum == 0) {
                ans = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    ans = Math.max(ans, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr, arr.length));
    }
}
