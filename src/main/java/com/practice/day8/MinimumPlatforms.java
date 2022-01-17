package com.practice.day8;

import java.util.Arrays;

/*
Solution 1(Brute Force):
1.
2.
3.

Time Complexity: O()
Space Complexity: O()

Solution 2(Better):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

Solution 3(Optimal):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

*/
public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count = 1, max = 1;
        int j = 0, i = 1;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else if (arr[i] > dep[j]) {
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
