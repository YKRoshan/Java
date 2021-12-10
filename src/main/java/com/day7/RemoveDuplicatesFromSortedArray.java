package com.day7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;


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
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;
    }

    public int removeDuplicates1(int[] arr) {
        SortedSet<Integer> set = new TreeSet<>();
        set.addAll(Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList()));
        int c = 0;
        for (int i : set)
            arr[c++] = i;

        return set.toArray().length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
    }
}
