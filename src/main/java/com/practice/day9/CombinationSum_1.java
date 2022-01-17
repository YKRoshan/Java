package com.practice.day9;

import java.util.ArrayList;
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
public class CombinationSum_1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumUtil(candidates, candidates.length - 1, target, new ArrayList<>(), res);
        return res;
    }

    private void combinationSumUtil(int[] candidates, int n, int target, List<Integer> temp, List<List<Integer>> res) {
        if (n < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target >= candidates[n]) {
            temp.add(candidates[n]);
            combinationSumUtil(candidates, n, target - candidates[n], temp, res);
            temp.remove(temp.size() - 1);
        }
        combinationSumUtil(candidates, n - 1, target, temp, res);
    }


    public static void main(String[] args) {
        CombinationSum_1 combinationSum1 = new CombinationSum_1();
        int[] arr = new int[]{4, 3, 6, 7};

        List<List<Integer>> res = combinationSum1.combinationSum(arr, 7);
        System.out.println(res);
    }
}
