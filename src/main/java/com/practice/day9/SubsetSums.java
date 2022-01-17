package com.practice.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class SubsetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] array = arr.stream().mapToInt(i -> i).toArray();

        subsetSumsUtil(array, res, n - 1, 0);
        Collections.sort(res);
        return res;
    }

    private void subsetSumsUtil(int[] array, ArrayList<Integer> res, int n, int sum) {
        if (n < 0) {
            res.add(sum);
            return;
        }
        subsetSumsUtil(array, res, n - 1, sum + array[n]);
        subsetSumsUtil(array, res, n - 1, sum);
    }

    public static void main(String[] args) {
        SubsetSums subsetSums = new SubsetSums();
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(1);
        list.add(2);
        list.add(3);
//        list.add(4);
//        list.add(5);
        ArrayList<Integer> res = subsetSums.subsetSums(list, list.size());
        System.out.println(res);
    }
}
