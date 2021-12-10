package com.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
1.Sort the intervals
2.Take first array as a valueToCompare and compare with next element
3.If next element merges with valueToCompare then merge it
4.Else add it to ans and update valueToCompare
Time Complexity: O(N)
Space Complexity: O(1)

*/
public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0] = new int[]{1, 3};
        intervals[1] = new int[]{2, 6};
        intervals[2] = new int[]{8, 10};
        intervals[3] = new int[]{15, 18};
        intervals = merge(intervals);
        for (int[] i : intervals) {
            System.out.println(i[0] + " " + i[1]);
        }
    }

    public static int[][] merge(int[][] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int[] valueToCompare = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (valueToCompare[1] >= arr[i][0]) {
                valueToCompare[1] = Math.max(arr[i][1], valueToCompare[1]);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(valueToCompare[0]);
                l.add(valueToCompare[1]);
                list.add(l);
                valueToCompare = arr[i];
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        l.add(valueToCompare[0]);
        l.add(valueToCompare[1]);
        list.add(l);
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}

