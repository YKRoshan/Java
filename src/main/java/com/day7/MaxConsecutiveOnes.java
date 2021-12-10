package com.day7;

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
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] arr) {
        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else count = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 0, 1, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
