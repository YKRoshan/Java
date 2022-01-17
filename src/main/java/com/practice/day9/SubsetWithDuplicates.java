package com.practice.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class SubsetWithDuplicates {
    List<List<Integer>> subsetSums(ArrayList<Integer> arr, int n) {
        Set<List<Integer>> res = new HashSet<>();
        int[] array = arr.stream().mapToInt(i -> i).toArray();

        subsetSumsUtil(array, res, n - 1, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> l : res) {
            ans.add(l);
        }
        return ans;
    }

    private void subsetSumsUtil(int[] array, Set<List<Integer>> res, int n, ArrayList<Integer> list) {
        if (n < 0) {
            res.add(list);
            return;
        }
        subsetSumsUtil(array, res, n - 1, list);
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i : list) temp.add(i);
        temp.add(array[n]);
        subsetSumsUtil(array, res, n - 1, temp);
    }

    public static void main(String[] args) {
        SubsetWithDuplicates subsetWithDuplicates = new SubsetWithDuplicates();
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
//        list.add(4);
//        list.add(5);
        List<List<Integer>> res = subsetWithDuplicates.subsetSums(list, list.size());
        System.out.println(res);
    }
}
