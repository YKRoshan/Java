package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
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
        int[] interval = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (interval[1] >= arr[i][0]) {
                interval[1] = interval[1] < arr[i][1] ? arr[i][1] : interval[1];
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(interval[0]);
                l.add(interval[1]);
                list.add(l);
                interval = arr[i];
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        l.add(interval[0]);
        l.add(interval[1]);
        list.add(l);
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}